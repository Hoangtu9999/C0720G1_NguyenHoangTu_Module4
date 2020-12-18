$('.editProduct').click(function () {
    event.preventDefault();
    let id = $(this).attr('data');
    $('#modalEdit').modal('show');

    $.ajax({
        type: "GET", //GET, DELETE, PUT...
        url: "/api/product/modal-edit/" + id,
        dataType: "json",
        // dataType: "text",
        success: function (product) {
            $("#idEdit").val(product.id);
            $("#nameEdit").val(product.name);
            // $("#pictureEdit").val(product.picture);
            $("#warrantyPeriodEdit").val(product.warrantyPeriod);

            $("#quantityEdit").val(product.quantity);
            $("#unitEdit").val(product.unit);
            $("#retailPriceEdit").val(product.retailPrice);
            $("#productTypeEdit").val(product.productType.id);
            $("#producerEdit").val(product.producer.id);
        },
        error: function (product) {
            console.log('error;');
        }
    });
});

$('.deleteProduct').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    console.log(url);
    swal({
        title: "Are you sure?",
        text: "Are you sure you want to delete this product?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((result) => {
        if (result) {
            $(
                function () {
                    $.get(url);
                    swal(
                        'Success!',
                        'Deleted Contract.',
                        'success'
                    ).then(function () {
                        location.reload();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            swal("Your imaginary file is safe!")
        ) {
            swal(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});


$(document).ready(function () {
    if ($("#hasErrorCreate").val() === "true") {
        $("#modalCreate").modal('show')
    }
});

$(document).ready(function () {
    if ($("#hasErrorEdit").val() === "true") {
        $("#modalEdit").modal('show')
    }
});

$(document).ready(function () {
    $("#btnEdit").click(function () {
        swal("Are you sure you want to do this?", {
            buttons: ["Oh noez!", true],
        });
    });
});
