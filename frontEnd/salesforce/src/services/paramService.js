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
//
        },
        paramUnidadList: function (scope) {
            $http.get(service + '/unidad_medida').success( //
                function (data) {
                    scope.unidadList = data.result;
                });
//
        },
        paramClaseList: function (scope) {
            $http.get(service + '/unidad_medida').success( //
                function (data) {
                    scope.unidadList = data.result;
                });
//
        }
    };

})
