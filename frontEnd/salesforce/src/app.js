var app = angular.module('app', ['ngCookies','ngRoute']).factory('serviceShare', function() {
    return {
        form : {},
        user : {
            id_app : '2220',
//            url_service : 'http://localhost:8080/rest/',
            username : '',
            password : ''
        }
    };

//definimos las rutas de la 'app'
}).config(['$routeProvider', function($routes) {
  $routes.
  	  when('/home', {
  		  templateUrl: 'src/views/home.html',
  		  controller: 'HomeController'
	  }).
      when('/administracion', {
          templateUrl: 'src/views/admin.html',
          controller: 'AdminController'
      }).
      when('/clientes', {
          templateUrl: 'src/views/clientes.html',
          controller: 'ClienteController'
      }).
      when('/almacenes', {
          templateUrl: 'src/views/bodegas.html',
          controller: 'BodegasController'
      }).
      when('/inventarios', {
          templateUrl: 'src/views/inventario.html',
          controller: 'InventarioController'
      }).
      when('/categorias', {
          templateUrl: 'src/views/categorias.html',
          controller: 'CategoriasController'
      }).
      when('/clases', {
          templateUrl: 'src/views/clases.html',
          controller: 'ClasesController'
      }).
      when('/marcas', {
          templateUrl: 'src/views/marcas.html',
          controller: 'MarcasController'
      }).
      when('/unidades', {
          templateUrl: 'src/views/unidades.html',
          controller: 'UnidadesController'
      }).

      when('/inventarios/:id', {
          templateUrl: 'src/views/inventario.html',
          controller: 'InventarioController'
      }).
      when('/articulo/:id', {
          templateUrl: 'src/views/articulo-info.html',
          controller: 'InventarioController'
      }).
      when('/movimientos', {
          templateUrl: 'src/views/movimiento.html',
          controller: 'MovimientoController'
      }).
      when('/cliente-productos', {
          templateUrl: 'src/views/cliente_productos.html',
          controller: 'ClienteProductoController'
      }).
      when('/compras', {
          templateUrl: 'src/views/compras.html',
          controller: 'ComprasController'
      }).
      when('/ventas', {
          templateUrl: 'src/views/ventas.html',
          controller: 'VentasController'
      }).
      when('/reporte_etiqueta', {
          templateUrl: 'src/views/reportes/reporte_etiqueta.html',
          controller: 'ReportesController'
      }).

      when('/articulos-stock', {
          templateUrl: 'src/views/articulosStock.html',
          controller: 'ArticulosStockController'
      }).
      otherwise({
		  redirectTo: '/home'});

}]).config(['$routeProvider', function($routeProvider){

    //this loads up our routes dynamically from the previous object
    for(var path in window.routes) {
        $routeProvider.when(path, window.routes[path]);
    }
    $routeProvider.otherwise({redirectTo: '/home'});

}]).run(function(){
});


