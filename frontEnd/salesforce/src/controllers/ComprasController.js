/**
* HomeController
*/
function ComprasController($scope, $http, $cookies, serviceShare) {

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
        invoice_number: 10,
        customer_info:  {name: "Mr. John Doe", web_link: "John Doe Designs Inc.", address1: "1 Infinite Loop", address2: "Cupertino, California, US", postal: "90210"},
        company_info:  {name: "Metaware Labs", web_link: "www.metawarelabs.com", address1: "123 Yonge Street", address2: "Toronto, ON, Canada", postal: "M5S 1B6"},
        items:[ {codigo:0001, qty:10, description:'Gadget', cost:9.95}]};

    if(localStorage["compra"] == "" || localStorage["compra"] == null){
        $scope.compra = sample_compra;
    }
    else{
        $scope.compra =  JSON.parse(localStorage["compra"]);
    }
    $scope.addItem = function() {
        $scope.compra.items.push({qty:0, cost:0, description:""});
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


}