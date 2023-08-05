$('.date-format').datetimepicker({
    format: 'YYYY-MM-DD'
});

$('#plus').on('shown.bs.modal', function () {
    $('#plus').trigger('focus')
})