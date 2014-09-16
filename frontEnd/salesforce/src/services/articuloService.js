/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

app.service("inventarioService", function ($http,$cookies) {

    return {
        saveArticulo: function (data) {
            var result;  //
            $http({
                method: 'POST',
                url: service + '/articulo/guardar',
                data: JSON.stringify(data)
            }).success(function (response) {
                    result = response;
//                    console.log(result.message);
                    return result;
            }). error(function (response) {   //
                    alert("ERROR! intente mas tarde"+result)
            });
        }
    };

})
