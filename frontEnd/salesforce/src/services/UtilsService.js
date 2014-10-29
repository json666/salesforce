/**
 * Created with JetBrains PhpStorm.
 * User: esalamanca
 * Date: 04-08-14
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */

app.service("utilsService", function ($http) {
    return {
        selectValue: function (listado, idSelected) {
            var index = '';
            if (idSelected != undefined && idSelected != null) {
                for (var i = 0; i < listado.length; i++) {
                    index = i;
                    if (listado[i].codigo == idSelected.codigo) {
                        break;
                    }
                }
            }
            return index;
        },
        //Obtiene el indice de un array que es igual a un objeto
        arrayObjectIndexOf: function (arr, obj) {
            for (var i = 0; i < arr.length; i++) {
                if (angular.equals(arr[i], obj)) {
                    return i;
                }
            }
            return -1;
        },
        getDateFormat: function(fecha,formato,separador){
//            Ejemplo de fecha: Fri Sep 05 2014 11:06:37 GMT-0400
            var dd = fecha.getDate();
            var mm = fecha.getMonth() + 1; //Enero is 0!
            var yyyy = fecha.getFullYear();
            if (dd < 10) {
                dd = '0' + dd
            }
            if (mm < 10) {
                mm = '0' + mm
            }
            var fechaFormateada;
            switch (formato){
                case 'yyyymmdd':
                    fechaFormateada= yyyy + separador + mm + separador + dd;
                    break;
                default :
                    console.log("formato por defecto en UtilsService");
                    fechaFormateada= dd + separador + mm + separador + yyyy;
            }
            return fechaFormateada;
        }
    }
});