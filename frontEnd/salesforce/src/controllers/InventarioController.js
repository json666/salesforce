/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */

function InventarioController($scope, $http, $cookies, $routeParams, serviceShare, paramService) {
    console.log('--->admin');
    var id = $routeParams.id;

    //Cargando parametricas
    paramService.paramMarcasList($scope);
    paramService.paramUnidadList($scope);

    //$scope.cargarClase();

    $scope.formData = {}
    $http.get(service + '/categoria').success( //
        function (data) {
            var codigoCategoria;
            if(data.success){
                $scope.categoriaList = data.result;
            }else{
                $("#ModalArticulo").modal('hide');
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Ocurrio un problema al cargar los datos');
            }

        });
    console.log("CODIGO");


    $scope.cargarClase = function () {
        console.log("CODIGO"+$scope.formData.clasif_categoria.id);
        if ($scope.formData.clasif_categoria != null) {
            codigoCategoria = $scope.formData.clasif_categoria.id
        } else {
            codigoCategoria = 0;
        }

        $http.get(service + '/categoria/' + codigoCategoria + '/clase').success( //
            function (data) {
                if(data.success){
                    console.log('RESULT CATEGORIA');
                    $scope.claseList = data.result;
                }else{
                    $("#ModalArticulo").modal('hide');
                    $('#alertSucces').modal('show');
                    $("#mensajeAlertSucces").text('Ocurrio un problema al cargar los datos Categoria');
                }

            });
    }

    /*$scope.cargarClase = function () {
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
    }*/
    //console.log('CODIGO'+angular.toJson($scope.formData.clasif_categoria.id));
// begin process the form proveedores

//    inventarioService.articuloList($scope);
    $("#imageUpload").empty();
    console.log('PARTE UPLOAD IMAGE');
    $scope.formData.fotografia = {};
    $scope.cargarImagen = function () {
        console.log('CARGANDO IMAGEN');
        $("#imageUpload").empty();
        $('<div id="content_image" style="width: 300px">' + '<img class="img-thumbnail img-responsive " src="src/img/upload.jpg">' + '</div> ').appendTo('#imageUpload');

        console.log('CARGANDO IMAGEN........');
        console.log(service + '/uploadFiles');
        $('.inputFiles').fileupload({
            //                formData: {idDocumento: id},
            url: service + '/uploadFiles',
            //contentType:'multipart/form-data',
            headers: {'Content-Type': 'multipart/form-data'},
            dataType: 'json',
            method: 'POST',
            beforeSend: function (request) {

            },
            add: function (e, data) {

                console.log('ADD' + service + '/uploadFiles');
                var FileExt = (data.originalFiles[0].name).substring((data.originalFiles[0].name).lastIndexOf('.') + 1, data.originalFiles[0].name.length);
                if (FileExt.toLocaleLowerCase() == "png" || FileExt.toLocaleLowerCase() == "jpg" || FileExt.toLocaleLowerCase() == "gif") {
                    if (data.originalFiles[0].size <= 2097152) {//archivos <= 2 MB
                        //console.log('DATA IMAGE:' + data);
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
                $("#imageUpload").empty();
                $('<div id="content_image" style="width: 300px">' + '<img class="img-thumbnail img-responsive " src="src/img/upload.jpg">' + '</div> ').appendTo('#imageUpload');
            },
            headers: {
                'Access-Control-Allow-Origin': '*'
            },
            done: function (e, data) {
                //$scope.loading=false;
                console.log('DONE::::::::::::::::::::::::');
                if (data.result.success != false) {
                    console.log('DONE 1::::::::::::::::::::::::');
                    //$("#imagenUpload").find("img").css("display", "block");
                    if (data.result.result[0] != null) {
                        $scope.formData.fotografia = data.result.result[0].bytes;
                        //console.log('TOJSONBYTES:' + angular.toJson(data.result.result[0].bytes));
                        console.log('DONE 2::::::::::::::::::::::::');
                        console.log('DONE 3::::::::::::::::::::::::');
                        //console.log('IMAGEN..:'+angular.toJson(data.result.result));

                        $.each(data.result.result, function (index, file) {
                            console.log('DATO A MOSTRAR:'+index+'------'+angular.toJson(file.fileName));
                            $("#imageUpload").empty();
                            $('<div id="content_image" style="max-width: 350px">' + '<img class="img-thumbnail img-responsive" src="' + service + '/getImage/' + index + '">' + '</div> ').appendTo('#imageUpload');
                            //$('<div id="content_image" style="max-width: 350px">' + '<img ng-show="show" ng-src="data:image/JPEG;base64,"'+file.bytes+'">' + '</div> ').appendTo('#imageUpload');
                        });


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

    $scope.cancel = function () {
        var validator = $("#artForm").validate();
        validator.resetForm()
        $(".form-group").removeClass('has-error');
        $("#imageUpload").empty();


    }
    $scope.calculaMargenGanancia = function () {
        if ($scope.formData.precio != null && $scope.formData.precioCosto != null) {
            var precio = $scope.formData.precio;
            var precioCosto = $scope.formData.precioCosto;
            $scope.formData.margenGanancia = precioCosto - precio;
        } else {
            console.log('Datos Nulos');
        }
    }

    if (id == null || id.length == 0) {
        //console.log('FORMDATA:' + angular.toJson($scope.formData));

        $scope.save = function () {

            if (!$("#artForm").valid()) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").html('Error! debe llenar los campos requeridos');
                return false
            }
            else {
                $http({
                    method: 'POST',
                    url: service + '/articulo/guardar',
                    data: JSON.stringify($scope.formData)
                }).success(function (data) {
                    result = data;
                    console.log('STATUS' + data.success);
                    if (data.success) {
                        $scope.formData = null;
                        $scope.listadoArticuloshabilitados();
//                        inventarioService.articuloList($scope);

                        $("#ModalArticulo").modal('hide');
                        $('#alertSucces').modal('show');
                        $("#mensajeAlertSucces").text('Registro Guardado');
                    } else {
                        $("#ModalArticulo").modal('hide');
                        $('#alertSucces').modal('show');
                        $("#mensajeAlertSucces").text('Verifique el codigo de Articulo ya se encuentra Registrado');
//                        inventarioService.articuloList($scope);
                    }

                }).error(function (data) {   //
                    $('#alertError').modal('show');
                    $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
//                    inventarioService.articuloList($scope);
                    $('#dataTableProductos').show()

                });
            }

        }
    }
    else {
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
                if ($scope.formData.fotografia == null) {
                    alert("Imagen no disponible");
                    $scope.show = false
//                    $('<div id="content_image" style="width: 300px">' + '<img class="img-thumbnail img-responsive " src="src/img/upload.jpg">' + '</div> ').appendTo('#imageUpload');
//                    $('<div id="content_image" style="width: 300px">' + '<img class="img-thumbnail img-responsive " src="src/img/upload.jpg">' + '</div> ').appendTo('#imageUpload');
                } else {
                    $scope.show = true;
                }
                $("#ModalArticuloInfo").modal({
                    show: true,
                    backdrop: 'static',
                    keyboard:false
                });
            }).error(function (data, status) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
            });
    }
//Lista proveedores


    $scope.link = function () {
        location.href = '#/inventarios';

    };
// ends proveedores


// lista articulos begin
    $scope.listadoArticuloshabilitados = function () {
        $("#loading").css('display', 'block');
        var oTable = $('#dataTableProductos');
        $http.get(service + '/articulosHabilitados').success(

            function (data, status, headers, config) {
                $("#loading").css('display', 'none');
                $scope.tableProveedores = data.result;
                oTable = $('#dataTableProductos').dataTable(
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
                                "mData": "descripcionArticulo"
                            },
                            {
                                "mData": "codigoArticulo"
                            },{
                                "mData": "precio"
                            },
                            {
                                "mData": "precioCosto"
                            },
                            {
                                "mData": "margenGanancia"
                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var a = " <a href='#/inventarios/" + oObj.id + "' class='btn btn-default'><i class='fa fa-search'></i></a>";
                                    return a;

                                }
//                                <div style="float: right"><button class="btn btn-primary btn-sm" data-toggle='modal'  data-target="#ModalArticulo"><i class="fa fa-plus"></i> Reg. Producto</button></div>

                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var b = " <a href='#/inventarios/" + oObj.id + "' class='btn btn-primary'><i class='fa fa-edit'></i></a>";
                                    return b;

                                }
//                                <div style="float: right"><button class="btn btn-primary btn-sm" data-toggle='modal'  data-target="#ModalArticulo"><i class="fa fa-plus"></i> Reg. Producto</button></div>

                            },
                            {
                                "bSortable": false,
                                "mData": function (oObj) {
                                    var c = " <a href='#/cliente-info/" + oObj.id + "' class='btn btn-danger'><i class='fa fa-trash-o'></i></a>";
                                    return c;
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
                alert('Error:' + data.result);
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
    }
    $scope.listadoArticuloshabilitados();

//    lista articlus ends



    $scope.pdf = function () {
        alert("testaaaa")
//    function demoFromHTML() {
        var pdf = new jsPDF('p', 'pt', 'letter')
            , source = $('#test')[0]
            , specialElementHandlers = {
                // element with id of "bypass" - jQuery style selector
                '#bypassme': function (element, renderer) {
                    // true = "handled elsewhere, bypass text extraction"
                    return true
                }
            }

        margins = {
            top: 80,
            bottom: 60,
            left: 40,
            width: 522
        };
        pdf.fromHTML(
            source // HTML string or DOM elem ref.
            , margins.left // x coord
            , margins.top // y coord
            , {
                'width': margins.width // max width of content on PDF
                , 'elementHandlers': specialElementHandlers
            },
            function (dispose) {
                // dispose: object with X, Y of the last line add to the PDF
                //          this allow the insertion of new lines after html
                pdf.save('Test.pdf');
            },
            margins
        )
//    }
    }

}

//categorias begin
function CategoriasController($scope, $http, $routeParams, serviceShare, paramService) {

    var id = $routeParams.id;

    //categorias save
    if (id == null || id.length == 0) {
        $scope.saveCategoria = function () {
            $http({
                method: 'POST',
                url: service + '/categoria/guardar',
                data: JSON.stringify($scope.formDataCategoria)
            }).success(function (response) {
                result = response;
                $scope.formDataCategoria = null
                $scope.listaCategorias();
                $("#ModalCategoria").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');

            }).error(function (response) {   //
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');

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
                console.log("#####categorias")
                console.log(angular.toJson($scope.formDataCategoria));
            }).error(function (data, status) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
            });
    }

    //categorias list
    $scope.listaCategorias = function () {
        $("#loading").css('display', 'block');
        var oTable = $('#dataTableCategorias');
        $http.get(service + '/categoria').success(
            function (data, status, headers, config) {
                $("#loading").css('display', 'none');
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
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
//                alert(data.result);
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
// ends categorias
    }
    $scope.listaCategorias();

}

//begin clases
function ClasesController($scope, $http, $routeParams, serviceShare, paramService) {
    var id = $routeParams.id;
    //clases save

    $scope.cargarCategoria=function(){
        console.log('CATEGORIA');
        $http.get(service + '/categoria').success( //
            function (data) {
                var codigoCategoria;
                if(data.success){
                    $scope.categoriaClaseList = data.result;
                }else{
                    $("#ModalClase").modal('hide');
                    $('#alertSucces').modal('show');
                    $("#mensajeAlertSucces").text('Ocurrio un problema al cargar los datos');
                }

            });
    }
    $scope.cargarCategoria();


    $scope.formDataClase = {
        "clasif_categoria": null
    }

    if (id == null || id.length == 0) {
        $scope.saveClase = function () {
            $http({
                method: 'POST',
                url: service + '/clases/guardar',
                data: JSON.stringify($scope.formDataClase)
            }).success(function (response) {
                result = response;
                $scope.formDataClase = null;
                $scope.listadoClases();
                $("#ModalClase").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text(response.message);

            }).error(function (response) {   //
                $('#alertError').modal('show');
                $("#mensajeAlertError").text('Error! intente nuevamente');

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/clases'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataClase = data.result;
                console.log("####categorias")
                console.log(angular.toJson($scope.formDataClase));
            }).error(function (data, status) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
            });
    }

    $scope.listadoClases = function () {
        $("#loading").css('display', 'block');
        var oTable = $('#dataTableClases');
        $http.get(service + '/clases').success(
            function (data, status, headers, config) {
                $("#loading").css('display', 'none');
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
                                "mData": "descripcionClase"
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
// ends clses
    }
    $scope.listadoClases();

}
//begin marcas
function MarcasController($scope, $http, $routeParams, serviceShare, paramService) {
    var id = $routeParams.id;

    //marcas save
    if (id == null || id.length == 0) {
        $scope.saveMarca = function () {
            $http({
                method: 'POST',
                url: service + '/marcas/guardar',
                data: JSON.stringify($scope.formDataMarca)
            }).success(function (response) {
                result = response;
                $scope.formDataMarca = null;
                $scope.listadoMarcasProducto();
                $("#ModalMarca").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text('Registro Guardado');

            }).error(function (response) {   //
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/marcas_producto'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formDataMarcas = data.result;
                console.log("####marcas")
                console.log(angular.toJson($scope.formDataMarcas));
            }).error(function (data, status) {
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
            });
    }
    $scope.listadoMarcasProducto = function () {
        $("#loading").css('display', 'block');
        var oTable = $('#dataTableMarcas');
        $http.get(service + '/marcas_producto').success(
            function (data, status, headers, config) {
                $("#loading").css('display', 'none');
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
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente');
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
// ends marcas
    }
    $scope.listadoMarcasProducto();

}

function UnidadesController($scope, $http, $routeParams, serviceShare, paramService) {
    var id = $routeParams.id;

    //begin unidades
    //unidades save
    if (id == null || id.length == 0) {
        $scope.saveUnidad = function () {
            $http({
                method: 'POST',
                url: service + '/unidad_medida/guardar',
                data: JSON.stringify($scope.formDataUnidad)
            }).success(function (response) {
                result = response;
                $scope.formDataUnidad = null;
                $("#ModalUnidad").modal('hide')
                $('#alertSucces').modal('show');
                $("#mensajeAlertSucces").text(response.message);
                $scope.listadoUnidades();

            }).error(function (response) {   //
                alert("ERROR! intente mas tarde")

            });
        }
        //inventarioService.saveArticulo($scope.formData);

    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/unidad_medida'
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                console.log("###unidades");
                $scope.formDataUnidad = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
    $scope.listadoUnidades=function(){
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
    }
    $scope.listadoUnidades();

}

