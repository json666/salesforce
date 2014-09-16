/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

app.service("paramService", function ($http) {

    return {
        paramMarcasList: function (scope) {
            $http.get(service + '/marcas_producto').success( //
             function (data) {
             scope.marcasList = data.result;
             });
//            $.ajax({
//                type: 'GET',
//                async: false,
//                url: 'http://localhost:8080/b-param/rest/pais',
//                success: function(data) {
//                    scope.paisesList = data.result;
//                },
//                error: function (msg) {
//                    console.log(msg);
//                }
//            });
        }
    };

})
