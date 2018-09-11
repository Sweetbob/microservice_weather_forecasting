$(function () {
    $("#selectedCity").change(function () {
        var cityId = $("#selectedCity").val();
        var uri = "/report/city_id/" + cityId;
        window.location.href = uri;
    })
});