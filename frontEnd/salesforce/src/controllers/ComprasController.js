
function ComprasController($scope, $http, $cookies, serviceShare) {

    $scope.showprov = function(){
        $("#box-proveedor").fadeIn("slow")

        $http({
       method: 'GET',
            url: service+'/proveedores'
    }).success(function (data) { $scope.provList = data.result; });


}

    $scope.closeprov = function(){
        $("#box-proveedor").fadeOut("slow")
    }

    $scope.select =function(id){
        console.log("Proveedor Seleccionado:"+id);
        $http({
            method:'GET',
            url:service+'/proveedor/get/' + id
        }).success(
            function (data, status) {
                $scope.datosproveedor = data.result;
//                var pp = $scope.datosproducto.id;
//                console.log("Id producto:*****************************"+pp);
//                $scope.formData.producto.id = pp;
                console.log($scope.datosproveedor)
//                $("#saveSol").show();
//            console.log(angular.toJson(data.result));
            }).error(function (data, status, headers, config) {
                alert("Error de conexion con el servidor.");
            });
    }

    $scope.numeroDocumento = "YANAPAX SRL"
    $scope.direccion = "Ave. los leones nro. 5898 Alto Obrrajes"
    $scope.fecha = new Date();
//
//    $scope.productoList = {
//        items: [
//            {
//                "clave": 1,
//                "producto": "Hydrogen",
//                "cantidad": 2,
//                "precio": 10,
//                "importe": 20
//
//            }
//]
//    }
//
//
//    $http({
//        method: 'GET',
//        url: service+'/proveedores'
////        url: 'src/data/emp.json'
//    }).success(function (data) { $scope.provList = data.result; });

    var sample_compra = {
        numeroDocumento:11111111,
        tax: 13.00,
        compra_number: 10,
        proveedor:  {nombre: "Mr. John Doe", direccion: "1 Infinite Loop"},
        items:[ {codigo:0001, qty:10, description:'Anillo de Oro', cost:9.95}]};

    if(localStorage["compra"] == "" || localStorage["compra"] == null){
        $scope.compra = sample_compra;
    }
    else{
        $scope.compra =  JSON.parse(localStorage["compra"]);
    }
    $scope.addItem = function() {
        $scope.compra.items.push({codigo:"", qty:0, cost:0, description:""});
        $scope.literal = false;
    }

    $scope.removeItem = function(item) {
        $scope.compra.items.splice($scope.compra.items.indexOf(item), 1);
    }

    $scope.compra_sub_total = function() {
        var total = 0.00;
        angular.forEach($scope.compra.items, function(item, key){
            total += (item.qty * item.cost);
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

    //    $scope.nombre = "YANAPAX SRL"
//    $scope.direccion = "Ave. los leones nro. 5898 Alto Obrrajes"
//    $scope.fecha = new Date();
//
//    $scope.productoList = {
//        items: [
//            {
//                "clave": 1,
//                "producto": "Hydrogen",
//                "cantidad": 2,
//                "precio": 10,
//                "importe": 20
//
//            }
//]
//    }
//
//
//    $http({
//        method: 'GET',
//        url: service+'/proveedores'
////        url: 'src/data/emp.json'
//    }).success(function (data) { $scope.provList = data.result; });


}