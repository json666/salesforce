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
      when('/inventarios', {
          templateUrl: 'src/views/inventario.html',
          controller: 'InventarioController'
      }).

      when('/inventarios/:id', {
          templateUrl: 'src/views/inventario.html',
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


