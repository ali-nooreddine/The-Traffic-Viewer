function check_empty() {
if (document.getElementById('name').value === "" || document.getElementById('email').value === "" || document.getElementById('conatctno').value === "" || document.getElementById('message').value === "") {
window.alert("Fill All Fields !");
} else {
document.getElementById('form').submit();
window.alert("Form Submitted Successfully...");
}
}
//Function To Display Popup
function div_show() {
document.getElementById('abc').style.display = "block";
document.getElementById('map-canvas').style.zIndex = "-1";
document.getElementById('Mname').value = "";
document.getElementById('name').value === "";
document.getElementById('email').value === "";
document.getElementById('conatctno').value === "";
document.getElementById('message').value === "";
document.getElementById('mEmail').value === "";
document.getElementById('mConatct').value === "";
document.getElementById('mMessage').value === "";
}
//Function to Hide Popup
function div_hide(){
document.getElementById('abc').style.display = "none";
document.getElementById('map-canvas').style.zIndex = "0";
}

function div_show_report_radar() {
document.getElementById('report_radar').style.display = "block";
document.getElementById('map-canvas').style.zIndex = "-1";
}
//Function to Hide Popup
function div_hide_report_radar(){
document.getElementById('report_radar').style.display = "none";
document.getElementById('map-canvas').style.zIndex = "0";
}