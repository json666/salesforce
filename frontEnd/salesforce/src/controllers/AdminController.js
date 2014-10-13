/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */

function AdminController($scope, $http, $cookies, $routeParams, serviceShare) {
    console.log('--->admin');
    var id = $routeParams.id;
    $scope.formData = {}

// begin process the form proveedores
    if (id == null || id.length == 0) {
        $scope.save = function () {
//            adminService.saveProveedor($scope.formData);//
            $http({
                method: 'POST',
                url: service + '/proveedor/guardar',
                data: JSON.stringify($scope.formData)
            }).success(function (response) {
                result = response;
                $scope.listadoProveedores();
                alert(result.message)
                $scope.formData = null
                $("#ModalProveedor").modal('hide')
            }).error(function (response) {   //
                alert("ERROR! intente mas tarde")

            });
        };
    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/proveedor/get/' + id
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formData = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
    $scope.listadoProveedores = function () {
        var tableProveedores = new Array();
        var oTable = $('#dataTableProveedores');
        $http.get(service + '/proveedores').success(
            function (data, status, headers, config) {
                $scope.tableProveedores = data.result;
                oTable = $('#dataTableProveedores').dataTable(
                    {
                        "bJQueryUI": true,
                        "bAutoWidth": true,
                        "bProcessing": true,
                        "oLanguage": {
                            "sUrl": "src/js/i18n/dataTable_es.txt"
                        },
                        "aaData": $scope.tableProveedores,
                        "aoColumns": [
//                        {
//                            "mData": "id",
//                            "bSearchable": false,
//                            "bVisible": false
//                        },
                            {
                                "mData": null,
                                "bSortable": false
                            },
                            {
                                "mData": "numeroDocumento"
                            },
                            {
                                "mData": "nombre"
                            },
                            {
                                "mData": "direccion"
                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var a = " <a href='#/clientes/" + oObj.id + "' class='btn btn-primary'><i class='fa fa-edit'></i></a>";
                                    return a;

                                }

                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var b = " <a href='#/cliente-info/" + oObj.id + "' class='btn btn-danger'><i class='fa fa-trash-o'></i></a>";
                                    return b;
                                }
                            }


                        ],
                        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
                            $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
                            return nRow;
                        },
                        "bDestroy": true
                    });

            }).
            error(function (data, status, headers, config) {
                alert(data.result);
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
// ends proveedores
    }

    $scope.listadoProveedores();
//Lista proveedores


}


