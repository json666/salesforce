/**
 * User: esalamanca
 * Date: 03-01-14
 * Time: 12:06 PM
 * Directiva para la validacion jquery.
 */

app.directive('miValidacion', function() {

    //Funcion LINK que realiza la validacion
    function link(scope, elem, attrs) {

        var $form = $("form");

        var validateMethod = $.fn.validate;
        $.fn.validate = function (o) {
            if (o && o.rules) {
                for (var name in o.rules) {
                    var rule = o.rules[name];
                    if (rule.required === true) {
                        var label = $('label[for=' + name + ']');
                        if (!label.text().match("[*]$")) {
                            label.text(label.text() + "*");
                        }
                    }
                }
            }
            return $.proxy(validateMethod, this)(o);
        };

        var validator = $form.validate({
            rules: {
                numeroReferencia: {
                    required: true,
                    maxlength: 15,
                    minlength: 3
                },
                modoTransporte: {
                    required: true
                },
                /*numeroDeclaracion: {
                    maxLength: 20,
                    minLength: 10,
                    required: false
                },*/
                /*fechaAceptacion: {
                    date: true,
                    required: false
                },*/
                /*paisTramite: {
                    required: true
                },*/
                aduanaDespacho: {
                    required: true
                },
                regimenAduanero: {
                    required: true
                },
                tipoDespacho: {
                    required: true
                },
                tipoDocExportador: {
                    required: true
                },
                exportadorNumeroDocumento: {
                    maxlength: 15,
                    required: true
                },
                exportadorNombreORazonSocial: {
                    maxlength: 150,
                    required: true
                },
                exportadorDomicilio: {
                    maxlength: 150,
                    required: true
                },
                tipoDocDestinatario: {
                    required: true
                },
                destinatarioNumeroDocumento: {
                     maxlength: 15,
                     required: true
                },
                destinatarioNombreORazonSocial: {
                     maxlength: 150,
                     required: true
                },
                destinatarioDomicilio: {
                     maxlength: 200,
                     required: true
                },
                tipoDocDeclarante: {
                    required: true
                },
                declaranteNumeroDocumento: {
                    maxlength: 15,
                    required: true
                },
                declaranteNombreORazonSocial: {
                    maxlength: 150,
                    required: true
                },
                declaranteDomicilio: {
                    maxlength: 150,
                    required: true
                },
                paisDestino: {
                    required: true
                },
                aduanaSalida: {
                    required: true
                },
                lugarEmbarque: {
                    required: true
                },
                lugarDesembarque: {
                    required: true
                },
                valorFOB: {
                    min: 0.001,
                    max: 9999999999.999,
                    required: true
                },
                valorTransaccion: {
                    min: 0.001,
                    max: 9999999999.999,
                    required: true,
                    regex: "/^([0123456789]{0,10}.[0123456789]{0,3})$/"
                },
                totalBultos: {
                    min: 0.01,
                    max: 99999.99,
                    required: false
                },
                totalPesoBruto: {
                    min: 0.001,
                    max: 999999999999999.999,
                    required: false
                },
                obsGenerales: {
                    maxlength: 1000,
                    required: false
                }
            },
            highlight: function (element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            errorElement: 'span',
            errorClass: 'help-block',
            errorPlacement: function (error, element) {
                if (element.parent('.input-group').length) {
                    error.insertAfter(element.parent());
                } else {
                    error.insertAfter(element);
                }
            }
        });

        //Validar todos los campos despues de focus out
        $form.find(":input").bind("focusout", function(e) {
            $(this).valid();
        });

        /**
         * Validar al hacer click en "Verificacion de datos"
         */
        $("#btnVerifica").on("click", function() {
            if ($form.valid()) {
                $('#validar').modal('show');
                //$("#dueNueva").submit();
            } else {
                validator.focusInvalid();
            }
        });

        /**
         * Validar al hacer click en Registrar declaracion
         */
        $("#regDeclaracion").on("click", function() {
            if ($form.valid()) {
                $('#confirmar').modal('show');
                //$("#dueNueva").submit();
            } else {
                validator.focusInvalid();
            }
        });
    }

    return {
        restrict: 'E',
        link: link
    }
});