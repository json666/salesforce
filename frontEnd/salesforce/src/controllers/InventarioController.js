/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */

function InventarioController($scope, $http, $cookies, $routeParams, serviceShare, paramService, inventarioService) {
    console.log('--->admin');
    var id = $routeParams.id;

    //Cargando parametricas
    paramService.paramMarcasList($scope);
    paramService.paramUnidadList($scope);

    $scope.formData = {}
    $http.get(service + '/categoria').success( //
        function (data) {
            var codigoCategoria;
            $scope.categoriaList = data.result;
        });

    $scope.cargarClase = function () {
        //console.log("CODIGO"+$scope.formData.clasif_categoria.id);
        if ($scope.formData.clasif_categoria != null) {
            codigoCategoria = $scope.formData.clasif_categoria.id
        } else {
            codigoCategoria = 0;
        }

        $http.get(service + '/categoria/' + codigoCategoria + '/clase').success( //
            function (data) {
                $scope.claseList = data.result;
            });
    }

    $scope.cargarClase = function () {
//        alert("sdfds");
        console.log("CODIGO" + $scope.formData.clasif_categoria.id);
        if ($scope.formData.clasif_categoria != null) {
            codigoCategoria = $scope.formData.clasif_categoria.id
        } else {
            codigoCategoria = 0;
        }

        $http.get(service + '/categoria/' + codigoCategoria + '/clase').success( //
            function (data) {
                $scope.claseList = data.result;
            });
    }
    //console.log('CODIGO'+angular.toJson($scope.formData.clasif_categoria.id));
// begin process the form proveedores

    inventarioService.articuloList($scope);
    console.log('PARTE UPLOAD IMAGE');
    $scope.cargarImagen = function () {
        console.log('CARGANDO IMAGEN........');
        console.log(service+'/uploadFiles');
        $('.inputFiles').fileupload({
            //                formData: {idDocumento: id},
            url: service + '/uploadFiles',
            method:'POST',
            crossDomain:true,
            beforeSend : function(request) {
                request.setRequestHeader("Access-control-Allow-Origin","*");
                request.setRequestHeader('Access-Control-Allow-Methods', 'OPTIONS,GET,POST,PUT,DELETE');
                request.setRequestHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
                request.setRequestHeader('Access-Control-Allow-Credentials: true');

            },
            xhrFields: {
                withCredentials: true
            },
            forceIframeTransport: true,
            add: function (e, data) {
                console.log('ADD'+service+'/uploadFiles');
                var FileExt = (data.originalFiles[0].name).substring((data.originalFiles[0].name).lastIndexOf('.') + 1, data.originalFiles[0].name.length);
                if (FileExt.toLocaleLowerCase() == "png" || FileExt.toLocaleLowerCase() == "jpg" || FileExt.toLocaleLowerCase() == "gif") {
                    if (data.originalFiles[0].size <= 2097152) {//archivos <= 2 MB
                        console.log('DATA IMAGE:' + data);
                        data.submit();

                    } else {
                        $('#mensajeAdjuntarArchivo').html('Archivo demasiado grande, se le recomienda cargar un archivo menor o igual a 2 MB.');
                        $('#tipoArchivoIncorrecto').modal('show');
                    }
                } else {
                    $('#mensajeAdjuntarArchivo').html('Tipo de archivo incorrecto, solo se permiten archivos PDF.');
                    $('#tipoArchivoIncorrecto').modal('show');
                }

            },
            beforeSend: function (request) {
                request.setRequestHeader("Access-Control-Allow-Origin", "*");
                //alert('...........Loading');
                //$scope.loading=true;
                $("#loading-div-background-img").css("display", "block");
            },
            headers: {
                'Access-Control-Allow-Origin': '*'
            },
            done: function (e, data) {
                //$scope.loading=false;
                console.log('DONE::::::::::::::::::::::::');
                if (data.result.success != false) {
                    //$("#imagenUpload").find("img").css("display", "block");
                    if (data.result.result[0] != null) {
                        if (data.result.result[0].idArchivo != null) {

                        } else {
                            $scope.$apply();
                            $('#mensajeAdjuntarArchivo').html('Ocurrio un error al adjuntar el archivo.');
                            $('#tipoArchivoIncorrecto').modal('show');
                        }
                    } else {
                        $scope.$apply();
                        $('#mensajeAdjuntarArchivo').html('Ocurrio un error al adjuntar el archivo.');
                        $('#tipoArchivoIncorrecto').modal('show');
                    }
                } else {
                    $scope.$apply();
                    $('#mensajeAdjuntarArchivo').html('Ocurrio un error al adjuntar el archivo.');
                    $('#tipoArchivoIncorrecto').modal('show');
                }
            }/*),
             progressall : function(e, data) {
             $scope.loading=false;
             }*/,
            error: function (e, data) {
                console.log("error cargando...");
                //$("#loading-div-background").css("display", "none");
                console.log(e);
            }
        });
    }

//    if ($("#itemFrm").valid()) {

    if (id == null || id.length == 0) {
        $scope.save = function () {
            if ($("#artForm").valid()) {
            $http({
                method: 'POST',
                url: service + '/articulo/guardar',
                data: JSON.stringify($scope.formData)
            }).success(function (response) {
                result = response;
                $scope.formData = null;
                inventarioService.articuloList($scope);

                $("#ModalArticulo").modal('hide');
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');
            }).error(function (response) {   //
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente')

            });
        }else{
            } $('#alertError').modal('show');
            $("#mensajeAlertError").html('Error! debe llenar los campos requeridos')
        }
    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/articulo/get/' + id
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                console.log("---->ARTICULO:" + id);

                console.log(JSON.stringify(data));
//                alert(JSON.stringify($scope.formData));//
                $scope.formData = data.result;
                $("#ModalArticuloInfo").modal({
                    backdrop: false,
                    keyboard: false
                });
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
//Lista proveedores


    $scope.link = function () {
        location.href = '#/inventarios';

    };
// ends proveedores

//categorias begin
    //categorias save
    if (id == null || id.length == 0) {
        $scope.saveCategoria = function () {
            $http({
                method: 'POST',
                url: service + '/categoria/guardar',
                data: JSON.stringify($scope.formData)
            }).success(function (response) {
                result = response;
                $scope.formDatazzz = null
                $("#ModalCategoria").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');

            }).error(function (response) {   //
                alert("ERROR! intente mas tarde")

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/categoria'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataCategoria = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
    //categorias list
    var oTable = $('#dataTableCategorias');
    $http.get(service + '/categoria').success(
        function (data, status, headers, config) {
            $scope.tableProveedores = data.result;
            oTable = $('#dataTableCategorias').dataTable(
                {
                    "bJQueryUI": true,
                    "bAutoWidth": true,
                    "bProcessing": true,
                    "oLanguage": {
                        "sUrl": "src/js/i18n/dataTable_es.txt"
                    },
                    "aaData": $scope.tableProveedores,
                    "aoColumns": [
//
                        {
                            "mData": null,
                            "bSortable": false
                        },
                        {
                            "mData": "descripcionCategoria"
                        },
                        {
                            "bSortable": false,
                            "mData": function (oObj) {
                                var ac = " <a href='#/clientes/" + oObj.id + "' class='btn btn-primary'><i class='fa fa-edit'></i></a>";
                                return ac;

                            }

                        },
                        {
                            "bSortable": false,
                            "mData": function (oObj) {
                                var bc = " <a href='#/cliente-info/" + oObj.id + "' class='btn btn-danger'><i class='fa fa-trash-o'></i></a>";
                                return bc;
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
// ends categorias

//begin clases
    //clases save
    if (id == null || id.length == 0) {
        $scope.saveClase = function () {
            $http({
                method: 'POST',
                url: service + '/clases/guardar',
                data: JSON.stringify($scope.formData)
            }).success(function (response) {
                result = response;
                $scope.formData = null
                $("#ModalClase").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');

            }).error(function (response) {   //
                alert("ERROR! intente mas tarde")

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/categoria'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataClase = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
    var oTable = $('#dataTableClases');
    $http.get(service + '/unidad_medida').success(
        function (data, status, headers, config) {
            $scope.tableProveedores = data.result;
            oTable = $('#dataTableClases').dataTable(
                {
                    "bJQueryUI": true,
                    "bAutoWidth": true,
                    "bProcessing": true,
                    "oLanguage": {
                        "sUrl": "src/js/i18n/dataTable_es.txt"
                    },
                    "aaData": $scope.tableProveedores,
                    "aoColumns": [
//
                        {
                            "mData": null,
                            "bSortable": false
                        },
                        {
                            "mData": "descripcionUnidad"
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
            alert(data.result);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
// ends clses

//begin marcas
    //marcas save
    if (id == null || id.length == 0) {
        $scope.saveClase = function () {
            $http({
                method: 'POST',
                url: service + '/marcas/guardar',
                data: JSON.stringify($scope.formData)
            }).success(function (response) {
                result = response;
                $scope.formData = null
                $("#ModalMarca").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');

            }).error(function (response) {   //
                alert("ERROR! intente mas tarde")

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/categoria'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataClase = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
    var oTable = $('#dataTableMarcas');
    $http.get(service + '/marcas_producto').success(
        function (data, status, headers, config) {
            $scope.tableMarcas = data.result;
            oTable = $('#dataTableMarcas').dataTable(
                {
                    "bJQueryUI": true,
                    "bAutoWidth": true,
                    "bProcessing": true,
                    "oLanguage": {
                        "sUrl": "src/js/i18n/dataTable_es.txt"
                    },
                    "aaData": $scope.tableMarcas,
                    "aoColumns": [
//
                        {
                            "mData": null,
                            "bSortable": false
                        },
                        {
                            "mData": "descripcionMarca"
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
            alert(data.result);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
// ends marcas

//begin unidades
    //unidades save
    if (id == null || id.length == 0) {
        $scope.saveUnidad = function () {
            $http({
                method: 'POST',
                url: service + '/marcas/guardar',
                data: JSON.stringify($scope.formData)
            }).success(function (response) {
                result = response;
                $scope.formData = null
                $("#ModalMarca").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');

            }).error(function (response) {   //
                alert("ERROR! intente mas tarde")

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/categoria'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataClase = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
    var oTable = $('#dataTableUnidades');
    $http.get(service + '/unidad_medida').success(
        function (data, status, headers, config) {
            $scope.tableUnidades = data.result;
            oTable = $('#dataTableUnidades').dataTable(
                {
                    "bJQueryUI": true,
                    "bAutoWidth": true,
                    "bProcessing": true,
                    "oLanguage": {
                        "sUrl": "src/js/i18n/dataTable_es.txt"
                    },
                    "aaData": $scope.tableUnidades,
                    "aoColumns": [
//
                        {
                            "mData": null,
                            "bSortable": false
                        },
                        {
                            "mData": "descripcionUnidad"
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
            alert(data.result);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
// ends marcas


}


