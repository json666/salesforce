/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

app.service("inventarioService", function ($http,$cookies) {

    return {
        articuloList: function ($scope) {
            var tableProductos = new Array();
            var oTable = $('#dataTableProdcutos');
            $http.get(service+'/articulosHabilitados').success(
                function (data, status, headers, config) {
                    $scope.tableProveedores = data.result;
                    oTable = $('#dataTableProdcutos').dataTable(
                        {
                            "bJQueryUI":true,
                            "bAutoWidth":true,
                            "bProcessing":true,
                            "oLanguage":{
                                "sUrl":"src/js/i18n/dataTable_es.txt"
                            },
                            "aaData":$scope.tableProveedores,
                            "aoColumns":[
//                        {
//                            "mData": "id",
//                            "bSearchable": false,
//                            "bVisible": false
//                        },
                                {
                                    "mData":null,
                                    "bSortable":  false
                                },
                                {
                                    "mData": "id"
                                },
                                {
                                    "mData":"descripcionArticulo"
                                },
                                {
                                    "mData":"cantidadReorden"
                                },
                                {
                                    "mData":"precioCosto"
                                },
                                {
                                    "bSortable": false,
                                    "mData":function (oObj) {
                                        var a = " <a href='#/inventarios/"+oObj.id+"' class='btn btn-primary'><i class='fa fa-edit'></i></a>";
                                        return a;

                                    }
//                                <div style="float: right"><button class="btn btn-primary btn-sm" data-toggle='modal'  data-target="#ModalArticulo"><i class="fa fa-plus"></i> Reg. Producto</button></div>

                                },
                                {
                                    "mData":function (oObj) {
                                        var b = " <a href='#/cliente-info/"+oObj.id+"' class='btn btn-danger'><i class='fa fa-trash-o'></i></a>";
                                        return b;
                                    }
                                }


                            ],
                            "fnRowCallback":function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
                                $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
                                return nRow;
                            }
                        });

                }).
                error(function (data, status, headers, config) {
                    alert(data.result);
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                });
//
        },

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
