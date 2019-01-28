$(document).ready(function() {
    //moment.format("yyyy-mm-dd hh:mm:ss");
    $(function() {
        $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD HH:MM:SS', // or 'l' (lowercase L) for non-zero-padded
            date: moment()
        });
    });
    $(function() {
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD HH:MM:SS', // or 'l' (lowercase L) for non-zero-padded
            date: moment()
        });
    });
    $(function () {
        $('#datetimepicker1').datetimepicker();
        $('#datetimepicker2').datetimepicker({
            useCurrent: false
        });
        $("#datetimepicker1").on("change.datetimepicker", function (e) {
            $('#datetimepicker2').datetimepicker('minDate', e.date);
        });
        $("#datetimepicker2").on("change.datetimepicker", function (e) {
            $('#datetimepicker1').datetimepicker('maxDate', e.date);
        });
    });

});