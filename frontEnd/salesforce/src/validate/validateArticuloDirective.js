/**
 * Created by rmagne on 24/09/14.
 */
app.directive('artForm', function () {

    //Funcion LINK que realiza la validacion
    function link(scope, element, attrs) {
        alert("sdfsdf");

        //Formulario que deseamos validar (lo agarramos como objeto jQuery)
        var $form = $("#artForm");

        /**
         * Ponemos un (*) en todos los campos marcados como requeridos
         * @type {Function|window.jQuery.fn.editableform.defaults.validate|Function|Function|Function|Function|Function|Function}
         */
        var validateMethod = $.fn.validate;
        $.fn.validate = function (o) {
            if (o && o.rules) {
                for (var name in o.rules) {
                    var rule = o.rules[name];
                    if ((rule.required != undefined) || (rule.requerido != undefined)) {
                        if (rule.required === true) {
                            var inputId = $('[name="' + name + '"]').attr("id");
                            var label = $('label[for=' + inputId + ']');
                            var nameFinal = name;
                            nameFinal = nameFinal.replace(/\./g, '_');
                            if ($("#requiredSpan" + nameFinal).length <= 0) {
                                label.before("<span id=\"requiredSpan" + nameFinal + "\" class=\"red bolder\">*</span> ");
                            }
                        }
                        else {
                            var inputId = $('[name="' + name + '"]').attr("id");
                            var label = $('label[for=' + inputId + ']');
                            var nameFinal = name;
                            nameFinal = nameFinal.replace(/\./g, '_');
                            if ($("#requiredSpan" + nameFinal).length <= 0) {
                                label.before("<span id=\"requiredSpan" + nameFinal + "\" class=\"green bolder\">*</span> ");
                            }
                        }
                    }
                }
            }
            return $.proxy(validateMethod, this)(o);
        };

        /**
         * Definimos las reglas de validacion del formulario
         */
        $form.validate({
            rules: {
                "formData.codigoArticulo": {
                    required: true,
                    maxlength: 36
                },
                "formData.nombreArticulo": {
                    required: true
                },
                "formData.descripcionArticulo": {
                    required: true,
                    maxlength: 35
                },
                "formData.clasif_unidad": {
                    required: true

                },
                "formData.clasif_marca": {
                    required: true

                },
                "formData.clasif_categoria": {
                    required: true

                },
                "formData.clasif_clase": {
                    required: true

                }

                //
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
        $form.find(":input").bind("focusout", function (e) {
            $(this).valid();
        });
    }

    return {
        restrict: 'E',
        link: link
    };
});