/**
 * 
 */
window.onload = function() {
        activarTab(document.getElementById("tabck-0"));
}; //al cargar salga abierta la primera pestaña
function activarTab(unTab) {
	
	
    try {
        //Los elementos div de todas las pestañas están todos juntos en una
        //única celda de la segunda fila de la tabla de estructura de pestañas.
        //Hemos de buscar la seleccionada, ponerle display block y al resto
        //ponerle display none.
        var id = unTab.id;
        if (id){
            var tr = unTab.parentNode || unTab.parentElement;
            var tbody = tr.parentNode || tr.parentElement;
            var table = tbody.parentNode || tbody.parentElement;
            //Pestañas en varias filas
            if (table.getAttribute("data-filas")!=null){
                var filas = tbody.getElementsByTagName("tr");
                var filaDiv = filas[filas.length-1];
                tbody.insertBefore(tr, filaDiv);
            }
            //Para compatibilizar con la versión anterior, si la tabla no tiene los
            //atributos data-min y data-max le ponemos los valores que tenían antes del
            //cambio de versión.
            var desde = table.getAttribute("data-min");
            if (desde==null) desde = 0;
            var hasta = table.getAttribute("data-max");
            if (hasta==null) hasta = MAXTABS;
            var idTab = id.split("tabck-");
            var numTab = parseInt(idTab[1]);
            //Las "tabdiv" son los bloques interiores mientras que los "tabck"
            //son las pestañas.
            var esteTabDiv = document.getElementById("tabdiv-" + numTab);
            for (var i=desde; i<=hasta; i++) {
                var tabdiv = document.getElementById("tabdiv-" + i);
                if (tabdiv) {
                    var tabck = document.getElementById("tabck-" + i);
                    if (tabdiv.id == esteTabDiv.id) {
                        tabdiv.style.display = "block";
                        tabck.style.color = "slategrey";
                        tabck.style.borderBottomColor = "rgb(235, 235, 225)";
                    } else {
                        tabdiv.style.display = "none";
                        tabck.style.color = "white";
                        tabck.style.borderBottomColor = "gray";
                    }
                }
            }
        }
    } catch (e) {
        alert("Error al activar una pestaña. " + e.message);
    }
}