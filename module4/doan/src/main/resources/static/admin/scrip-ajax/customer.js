$('.editCustomer').click(function () {
    event.preventDefault();
    let id = $(this).attr('data');
    $('#modalEdit').modal('show');

    $.ajax({
        type: "GET", //GET, DELETE, PUT...
        url: "/api/customer/modal-edit/" + id,
        dataType: "json",
        // dataType: "text",
        success: function (customer) {
            $("#idEdit").val(customer.id);
            $("#nameEdit").val(customer.name);
            $("#birthdayEdit").val(customer.birthday);
            if (customer.gender === false){
                $("#genderEdit").val('0');
            }else {
                $("#genderEdit").val('1');
            }
            $("#idCardEdit").val(customer.idCard);
            $("#emailEdit").val(customer.email);
            $("#numberPhoneEdit").val(customer.numberPhone);
            $("#addressEdit").val(customer.address);
        },
        error: function (customer) {
            console.log('error;');
        }
    });
});

$('.deleteCustomer').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    let id = $(this).attr('data');
    console.log(url);
    swal({
        title: "Are you sure?",
        text: "Are you sure you want to delete this product " + id  +"?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((result) => {
        if (result) {
            $(function () {
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

// $(document).ready(function () {
//     $("#btnEdit").click(function () {
//         swal("Are you sure you want to do this?", {
//             buttons: ["Oh noez!", true],
//         });
//     });
// });
