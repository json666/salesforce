
function VentasController($scope, $http, $cookies, $routeParams, serviceShare) {

    var id = $routeParams.id;


    $scope.compra = {
        fechaRegistro:fechaR,
        proveedoreBean: {
            id: null},
        "bodegaBean": {id:null},
        articuloBeanCompras: [{id:null}]
    };
    $scope.compra.articuloBeanCompras=[{id:"", codigoArticulo:"", nombreArticulo:null, precio:null,cantidadExistente:""}];

    /**
     * Muestra ventana de lista de proveedores
     */
    $scope.showcli = function(){
        $("#box-cliente").fadeIn("slow")

        $http({
       method: 'GET',
            url: service+'/clientes/detalle'
    }).success(function (data) { $scope.cliList = data.result; });
    }

//    $scope.selectBodega = function(){
        $http({
            method: 'GET',
            url: service+'/clasificador_bodega'
        }).success(function (data) { $scope.bodegaList = data.result; });
//    }

    $scope.fecha = new Date();
    var fechaR = $scope.fecha



    /**
     * Selecciona Cliente de la lista
     */
    $scope.select =function(id){
        console.log("Cliente Seleccionado:"+id);
        $http({
            method:'GET',
            url:service+'/cliente/buscar/' + id
        }).success(
            function (data, status) {
                $scope.proveedoreBean = data.result;
                var idProv = $scope.proveedoreBean.id;/**/
                console.log("Id producto:*****************************"+idProv);
                $scope.compra.proveedoreBean.id = idProv;
                console.log($scope.proveedoreBean)
//                $("#saveSol").show();
//            console.log(angular.toJson(data.result));
            }).error(function (data, status, headers, config) {
                alert("Error de conexion con el servidor.");
            });
        $("#box-cliente").fadeOut("slow")
    }

    /**
     * Cierra ventana de lista de proveedores
     */
    $scope.closeprov = function(){
        $("#box-cliente").fadeOut("slow");
    }
    $scope.addItem = function() {
        $scope.compra.articuloBeanCompras.push({id:"", codigoArticulo:"", nombreArticulo:null, precio:null,cantidadExistente:""});
        $scope.literal = false;
    }

    /**
     * Carga datos de un Articulo
     * @param codigoArticulo
     */

    $scope.buscaitem = function(codigoArticulo, pos){
        console.log("Producto:"+codigoArticulo);
        $http({
            method: 'GET',
            url: service + '/articulo/buscar/' + codigoArticulo
        }).success(
            function (data) {
                console.log("---->ARTICULO:" + codigoArticulo);
                console.log(JSON.stringify(data));
                $scope.formData = data.result;
                if ($scope.formData != null){
                    $scope.compra.articuloBeanCompras[pos]=({'id':$scope.formData.id,'codigoArticulo':$scope.formData.codigoArticulo,'nombreArticulo':$scope.formData.nombreArticulo,'precio':$scope.formData.precio})

                }
                else{
                    $('#alertError').modal('show');
                    $("#mensajeAlertError").text(data.message);
                }
            }).error(function (data, status) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
            });
    }


    $scope.change = function(){

        console.log("on change");
//        $scope.compra.articuloBeanCompras.push({id:"", codigoArticulo:0, nombreArticulo:0, precio:"",cantidadExistente:""});
    }



    $scope.removeItem = function(item) {
        $scope.compra.articuloBeanCompras.splice($scope.compra.articuloBeanCompras.indexOf(item), 1);
    }

    $scope.compra_sub_total = function() {
        var total = 0.00;
        angular.forEach($scope.compra.articuloBeanCompras, function(item, key){
            total += (item.cantidadExistente * item.precio);
        });
        return total;
    }
    $scope.calculate_tax = function() {
        return (($scope.compra.tax * $scope.compra_sub_total())/100);
    }
    $scope.calculate_grand_total = function() {
        localStorage["compra"] = JSON.stringify($scope.compra);
        return $scope.calculate_tax() + $scope.compra_sub_total();
    }

    $scope.tostring = function(){

        return $scope.num = $scope.compra_sub_total();
        console.log("tstring func"+$scope.num)

    }

    /**
     * Guarda Compra
     */
    if (id == null || id.length == 0) {
        $scope.saveVenta = function () {

            if (!$("#compraForm").valid()) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").html('Error! debe llenar los campos requeridos');
                return false
            }
            else {
                $http({
                    method: 'POST',
                    url: service + '/compra/guardar',
                    data:($scope.compra),
                    headers : { 'Content-Type': 'application/json; charset=utf-8' }
                }).success(function (response) {
                    result = response;
                    $('#alertSucces').modal('show');
                    $("#mensajeAlertSucces").text(response.message);
//                    $scope.listadoCompras();

                }).error(function (response) {   //
                    alert("ERROR! intente mas tarde")

                });
            }
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        alert("TODO servicio de listado")
//        $http({
//            method: 'GET',
//            url: service + '/compras'
//        }).success(
//            function (data, status) {
////                $("#loading-div-background").css("display", "none");
//                console.log("###unidades");
//                $scope.formDataUnidad = data.result;
//                console.log(angular.toJson(data.result));
//            }).error(function (data, status) {
//                alert("Error de conexion con el servidor.");
//            });
    }





    /**
    *Variables para Número Literal
    */

    var o=new Array("diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve");
    var u=new Array("cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve");
    var d=new Array("", "", "", "treinta", "cuarenta", "cincuenta", "sesenta", "sesenta", "ochenta", "noventa");
    var c=new Array("", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos");

    /**
     * funcion para convertir int to string
     */
    $scope.dec = function(n){
        $scope.num = $scope.tostring();
        console.log($scope.num)
//        alert(n);
//        $scope.esc = num;

        var n = parseFloat(n).toFixed(2);
        /*se limita a dos decimales, no sabía que existía toFixed() :)*/
        var p = n.toString().substring(n.toString().indexOf(".") + 1);
        /*decimales*/
        var m = n.toString().substring(0, n.toString().indexOf("."));
        /*número sin decimales*/
        var m = parseFloat(m).toString().split("").reverse();
        /*tampoco que reverse() existía :D*/
        var t = "";

        /*OJO: no hay tercer parámetro*/
        for (var i = 0; i < m.length;) {
            var x = t;
            /*formamos un número de 2 dígitos*/
            var b = m[i + 1] != undefined ? parseFloat(m[i + 1].toString() + m[i].toString()) : parseFloat(m[i].toString());
            /*analizamos y escribimos el 3 dígito primero q son las centenas*/
            t = m[i + 2] != undefined ? (c[m[i + 2]] + " ") : "";
            /*escribimos los 2 primeros dígitos: decenas y unidades*/
            t += b < 10 ? u[b] : (b < 30 ? o[b - 10] : (d[m[i + 1]] + (m[i] == '0' ? "" : (" y " + u[m[i]]))));
            /*analizamos si son 3 dígitos o menos, miles o millones*/
            t = i < 3 ? t : (i < 6 ? ((t == "uno" ? "mil " : (t + " mil ")) + x) : ((t == "uno" ? "un millón " : (t + " millones ")) + x));
            i = i + 3;
            /*tiene que ser más 3, se analizan cada 3 dígitos*/
        }
        /*y agregamos los decimales*/
        t += " con " + p + "/100";
        /*correcciones: siempre son necesarias*/
        t = t.replace("  ", " ");
        t = t.replace(" cero", "");
        t = t.replace("ciento y", "cien y");
        //alert("Numero: "+n+"\nNº Dígitos: "+m.length+"\nDígitos: "+m+"\nDecimales: "+p+"\nt: "+t);
        $scope.esc = t;
        console.log("literal --->"+$scope.esc)
        $scope.literal = true

    }

    /**
     *
     * @returns {boolean}
     * Registra cliente
     */
    $scope.saveCliente = function () {

        if (!$("#ClienteForm").valid()) {
            $('#alertError').modal('show');
            $("#mensajeAlertError").html('Error! debe llenar los campos requeridos');
            return false
        }
        else {
            $http({
                method: 'POST',
                url: service + '/cliente/guardar',
                data: JSON.stringify($scope.formDataClientes)
            }).success(function (response) {
                result = response;
                $scope.formDataClientes = null;
//                $scope.listadoClientes();
                $("#ModalCliente").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado Satisfactoriamente.');

            }).error(function (response) {   //
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');

            });
        }
    }

}