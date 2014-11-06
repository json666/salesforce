/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */


/*
REGISTRO CLIENTES
 */

//begin marcas
function ClienteController($scope, $http, $routeParams, serviceShare, paramService) {
    var id = $routeParams.id;

    /**
     * Limpia formulario marcas
     */
    /*$scope.regCliente = function(){
        $scope.formDataClientes = {}
        var validator = $("#ClienteForm").validate();
        validator.resetForm();
        $(".form-group").removeClass('has-error');
        console.log("-----------------------Registrar nueva Bodega--------------------")
    }*/

    /**
     * Guarda Marca
     */
    if (id == null || id.length == 0) {
        $scope.saveCliente = function () {

            if (!$("#ClienteForm").valid()) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").html('Error! debe llenar los campos requeridos');
                return false
            }
            else {
                $http({
                    method: 'POST',
                    url: service + '/clasificadorBodega/guardar',
                    data: JSON.stringify($scope.formDataClientes)
                }).success(function (response) {
                    result = response;
                    $scope.formDataClientes = null;
                    $scope.listadoClientes();
                    $("#ModalCliente").modal('hide')
                    $('#alertSucces').modal('show');
                    $("#mensajeAlertSucces").text('Registro Guardado Satisfactoriamente.');

                }).error(function (response) {   //
                    $('#alertError').modal('show');
                    $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');

                });
            }
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/clientes/detalle'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataClientes = data.result;
                console.log("####marcas")
                console.log(angular.toJson($scope.formDataClientes));
            }).error(function (data, status) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
            });
    }
    $scope.listadoClientes = function () {
        $("#loading").css('display', 'block');
        var oTable = $('#dataTableClientes');
        $http.get(service + '/clientes/detalle').success(
            function (data, status, headers, config) {
                $("#loading").css('display', 'none');
                $scope.tableClientes = data.result;
                oTable = $('#dataTableClientes').dataTable(
                    {
                        "bJQueryUI": true,
                        "bAutoWidth": true,
                        "bProcessing": true,
                        "oLanguage": {
                            "sUrl": "src/js/i18n/dataTable_es.txt"
                        },
                        "aaData": $scope.tableClientes,
                        "aoColumns": [
//
                            {
                                "mData": null,
                                "bSortable": false
                            },
                            {
                                "mData": "nombreComercial"
                            },
                            {
                                "mData": "razonSocial"
                            },
                            {
                                "mData": "nroDocumento"
                            },
                            {
                                "mData": "correo"
                            },
                            {
                                "mData": "ciudad,"
                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var ad = " <a href='#/clientes/" + oObj.id + "' class='btn btn-primary'><i class='fa fa-edit'></i></a>";
                                    return ad;

                                }

                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var bd = " <a href='#/cliente-info/" + oObj.id + "' class='btn btn-danger'><i class='fa fa-trash-o'></i></a>";
                                    return bd;
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
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
// ends marcas
    }
    $scope.listadoClientes();

}

