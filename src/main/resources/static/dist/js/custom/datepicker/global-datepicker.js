$('.date-format').datetimepicker({
    format: 'YYYY-MM-DD',
    display: {
        viewMode: 'calendar',
        components: {
            decades: false,
            year: true,
            month: true,
            date: true,
            hours: false,
            minutes: false,
            seconds: false
        }
    },
    localization: {
        locale: 'ko'
    }
});

let rangePicker = new tempusDominus.TempusDominus(document.getElementById('expensePeriod'), {
    dateRange: true,
    localization: {
        locale: 'ko',
        format: 'yyyy-MM-dd'
    },
    multipleDatesSeparator: '~',
    display: {
        viewMode: 'calendar',
        components: {
            calendar: true,
            date: true,
            month: true,
            year: true,
            decades: false,
            clock: false,
            hours: false,
            minutes: false,
            seconds: false,
        },
        icons: {
            date: 'fa fa-calendar',
            up: 'fa fa-arrow-up',
            down: 'bi bi-arrow-down',
            previous: 'fa fa-chevron-left',
            next: 'fa fa-chevron-right',
            today: 'fa fa-calendar-check',
            clear: 'fa fa-trash',
            close: 'fas fa-times',
        },
        buttons: {
            today: true,
            clear: true,
            close: true,
        }
    }
});

$('.datetimerange-input').daterangepicker({
    language: 'ko',
    format: 'YYYY/MM/DD'
});

$('#plus').on('shown.bs.modal', function () {
    $('#plus').trigger('focus')
})