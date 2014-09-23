/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */


app.directive('frmProveedor', function () {
    return {
        templateUrl: 'src/templates/proveedorSave.html'
    };
});

app.directive('listProveedor', function () {
    return {
        templateUrl: 'src/templates/proveedorList.html'
    };
});

app.directive('frmArticulo', function () {
    return {
        templateUrl: 'src/templates/articuloSave.html'
    };
});

app.directive('listArticulo', function () {
    return {
        templateUrl: 'src/templates/articuloList.html'
    };
});

app.directive('frmCategoria', function () {
    return {
        templateUrl: 'src/templates/categoriaSave.html'
    };
});

app.directive('listCategoria', function () {
    return {
        templateUrl: 'src/templates/categoriaList.html'
    };
});

app.directive('listClase', function () {
    return {
        templateUrl: 'src/templates/claseList.html'
    };
});

app.directive('listMov', function () {
    return {
        templateUrl: 'src/templates/movimientoList.html'
    };
});

