// Méthode de stockage
document.getElementById('find-me').onclick = function() {
	const coordonnees = {
		lat:document.getElementById('status').value,
		long:document.getElementById('map-link').value,

	};
	sessionStorage.setItem('coord',JSON.stringify(coordonnees));
	alert("Mémorisation effectuée");
};
// Méthode de lecture
document.getElementById('lecture').onclick = function() {
	const coordonnees = JSON.parse(sessionStorage.getItem('coord'));
	document.getElementById('status').value = coordonnees.lat;
	document.getElementById('map-link').value = coordonnees.long;
	alert("Lecture effectuée");
};
