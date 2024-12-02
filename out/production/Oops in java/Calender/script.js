class Calendar {
    constructor() {
        this.currentDate = new Date();
        this.events = JSON.parse(localStorage.getItem('events')) || [];
        this.currentView = 'month';
        this.initElements();
        this.initEventListeners();
        this.renderCalendar();
        this.initParticles();
        this.loadTheme();
    }

    initElements() {
        this.calendarGrid = document.getElementById('calendar-grid');
        this.currentMonthYear = document.getElementById('current-month-year');
        this.prevMonthBtn = document.getElementById('prev-month');
        this.nextMonthBtn = document.getElementById('next-month');
        this.monthViewBtn = document.getElementById('month-view');
        this.weekViewBtn = document.getElementById('week-view');
        this.dayViewBtn = document.getElementById('day-view');
        this.addEventBtn = document.getElementById('add-event');
        this.exportEventsBtn = document.getElementById('export-events');
        this.searchInput = document.getElementById('search-events');
        this.searchButton = document.getElementById('search-button');
        this.eventForm = document.querySelector('.event-form');
        this.eventFormEl = document.getElementById('event-form');
        this.cancelEventBtn = document.getElementById('cancel-event');
        this.themeToggleBtn = document.getElementById('theme-toggle');
    }

    initEventListeners() {
        this.prevMonthBtn.addEventListener('click', () => this.changeMonth(-1));
        this.nextMonthBtn.addEventListener('click', () => this.changeMonth(1));
        this.monthViewBtn.addEventListener('click', () => this.changeView('month'));
        this.weekViewBtn.addEventListener('click', () => this.changeView('week'));
        this.dayViewBtn.addEventListener('click', () => this.changeView('day'));
        this.addEventBtn.addEventListener('click', () => this.showEventForm());
        this.exportEventsBtn.addEventListener('click', () => this.exportEvents());
        this.searchButton.addEventListener('click', () => this.searchEvents());
        this.eventFormEl.addEventListener('submit', (e) => this.handleEventSubmit(e));
        this.cancelEventBtn.addEventListener('click', () => this.hideEventForm());
        this.calendarGrid.addEventListener('click', (e) => this.handleCalendarClick(e));
        this.themeToggleBtn.addEventListener('click', () => this.toggleTheme());
    }

    renderCalendar() {
        this.calendarGrid.innerHTML = '';
        this.currentMonthYear.textContent = this.currentDate.toLocaleString('default', { month: 'long', year: 'numeric' });

        const firstDay = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), 1);
        const lastDay = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, 0);

        if (this.currentView === 'month') {
            this.renderMonthView(firstDay, lastDay);
        } else if (this.currentView === 'week') {
            this.renderWeekView();
        } else if (this.currentView === 'day') {
            this.renderDayView();
        }

        this.highlightCurrentDate();
    }

    renderMonthView(firstDay, lastDay)renderMonthView(firstDay, lastDay) {
        for (let i = 0; i < firstDay.getDay(); i++) {
            this.createDayElement(new Date(firstDay.getTime() - (firstDay.getDay() - i) * 86400000), true);
        }

        for (let i = 1; i <= lastDay.getDate(); i++) {
            this.createDayElement(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), i));
        }

        for (let i = 1; i <= (6 - lastDay.getDay()); i++) {
            this.createDayElement(new Date(lastDay.getTime() + i * 86400000), true);
        }
    }

    renderWeekView() {
        const startOfWeek = new Date(this.currentDate);
        startOfWeek.setDate(this.currentDate.getDate() - this.currentDate.getDay());

        for (let i = 0; i < 7; i++) {
            const date = new Date(startOfWeek);
            date.setDate(startOfWeek.getDate() + i);
            this.createDayElement(date);
        }
    }

    renderDayView() {
        this.createDayElement(this.currentDate);
    }

    createDayElement(date, otherMonth = false) {
        const dayElement = document.createElement('div');
        dayElement.classList.add('calendar-day');
        if (otherMonth) dayElement.classList.add('other-month');

        const dayNumber = document.createElement('div');
        dayNumber.classList.add('day-number');
        dayNumber.textContent = date.getDate();
        dayElement.appendChild(dayNumber);

        const events = this.getEventsForDate(date);
        events.forEach(event => {
            const eventElement = document.createElement('div');
            eventElement.classList.add('event', event.category);
            eventElement.textContent = event.title;
            eventElement.dataset.eventId = event.id;
            dayElement.appendChild(eventElement);
        });

        dayElement.dataset.date = date.toISOString().split('T')[0];
        this.calendarGrid.appendChild(dayElement);
    }

    changeMonth(delta) {
        this.currentDate.setMonth(this.currentDate.getMonth() + delta);
        this.renderCalendar();
    }

    changeView(view) {
        this.currentView = view;
        this.monthViewBtn.classList.toggle('active', view === 'month');
        this.weekViewBtn.classList.toggle('active', view === 'week');
        this.dayViewBtn.classList.toggle('active', view === 'day');
        this.renderCalendar();
    }

    showEventForm(event = null) {
        const form = this.eventFormEl;
        if (event) {
            form.elements['event-title'].value = event.title;
            form.elements['event-date'].value = event.date;
            form.elements['event-time'].value = event.time;
            form.elements['event-category'].value = event.category;
            form.elements['event-description'].value = event.description;
            form.dataset.eventId = event.id;
        } else {
            form.reset();
            delete form.dataset.eventId;
        }
        this.eventForm.classList.remove('hidden');
    }

    hideEventForm() {
        this.eventForm.classList.add('hidden');
    }

    handleEventSubmit(e) {
        e.preventDefault();
        const form = e.target;
        const eventData = {
            id: form.dataset.eventId || Date.now().toString(),
            title: form.elements['event-title'].value,
            date: form.elements['event-date'].value,
            time: form.elements['event-time'].value,
            category: form.elements['event-category'].value,
            description: form.elements['event-description'].value
        };

        const existingEventIndex = this.events.findIndex(e => e.id === eventData.id);
        if (existingEventIndex !== -1) {
            this.events[existingEventIndex] = eventData;
        } else {
            this.events.push(eventData);
        }

        this.saveEvents();
        this.hideEventForm();
        this.renderCalendar();
    }

    handleCalendarClick(e) {
        if (e.target.classList.contains('event')) {
            const eventId = e.target.dataset.eventId;
            const event = this.events.find(e => e.id === eventId);
            if (event) {
                this.showEventForm(event);
            }
        }
    }

    getEventsForDate(date) {
        return this.events.filter(event => event.date === date.toISOString().split('T')[0]);
    }

    saveEvents() {
        localStorage.setItem('events', JSON.stringify(this.events));
    }

    exportEvents() {
        const csvContent = "data:text/csv;charset=utf-8," 
            + "Title,Date,Time,Category,Description\n"
            + this.events.map(e => `"${e.title}","${e.date}","${e.time}","${e.category}","${e.description}"`).join("\n");
        const encodedUri = encodeURI(csvContent);
        const link = document.createElement("a");
        link.setAttribute("href", encodedUri);
        link.setAttribute("download", "calendar_events.csv");
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }

    searchEvents() {
        const searchTerm = this.searchInput.value.toLowerCase();
        const filteredEvents = this.events.filter(event => 
            event.title.toLowerCase().includes(searchTerm) ||
            event.description.toLowerCase().includes(searchTerm)
        );
        this.renderCalendar();
        this.highlightSearchResults(filteredEvents);
    }

    highlightSearchResults(filteredEvents) {
        const eventElements = document.querySelectorAll('.event');
        eventElements.forEach(el => {
            const eventId = el.dataset.eventId;
            if (filteredEvents.some(e => e.id === eventId)) {
                el.style.boxShadow = '0 0 5px 2px yellow';
            } else {
                el.style.boxShadow = 'none';
            }
        });
    }

    highlightCurrentDate() {
        const today = new Date().toISOString().split('T')[0];
        const currentDateElement = this.calendarGrid.querySelector(`[data-date="${today}"]`);
        if (currentDateElement) {
            currentDateElement.classList.add('current-date');
        }
    }

    toggleTheme() {
        document.body.classList.toggle('dark-mode');
        localStorage.setItem('darkMode', document.body.classList.contains('dark-mode'));
    }

    loadTheme() {
        const darkMode = localStorage.getItem('darkMode') === 'true';
        if (darkMode) {
            document.body.classList.add('dark-mode');
        }
    }

    initParticles() {
        particlesJS('particles-js', {
            particles: {
                number: { value: 80, density: { enable: true, value_area: 800 } },
                color: { value: "#ff69b4" },
                shape: { type: "circle", stroke: { width: 0, color: "#000000" }, polygon: { nb_sides: 5 } },
                opacity: { value: 0.5, random: false, anim: { enable: false, speed: 1, opacity_min: 0.1, sync: false } },
                size: { value: 3, random: true, anim: { enable: false, speed: 40, size_min: 0.1, sync: false } },
                line_linked: { enable: true, distance: 150, color: "#ff69b4", opacity: 0.4, width: 1 },
                move: { enable: true, speed: 6, direction: "none", random: false, straight: false, out_mode: "out", bounce: false, attract: { enable: false, rotateX: 600, rotateY: 1200 } }
            },
            interactivity: {
                detect_on: "canvas",
                events: { onhover: { enable: true, mode: "repulse" }, onclick: { enable: true, mode: "push" }, resize: true },
                modes: { grab: { distance: 400, line_linked: { opacity: 1 } }, bubble: { distance: 400, size: 40, duration: 2, opacity: 8, speed: 3 }, repulse: { distance: 200, duration: 0.4 }, push: { particles_nb: 4 }, remove: { particles_nb: 2 } }
            },
            retina_detect: true
        });
    }
}

document.addEventListener('DOMContentLoaded', () => {
    new Calendar();
});