function changeMainImage(newImage) {
	document.getElementById('mainImage').src = newImage;
	document.getElementById('mainImageLink').href = newImage;

	// Log to the console
	console.log('Main image changed:', newImage);
}

var quantity = 1; // Initial quantity
document.getElementById('selectedQuantity').value = 1;
console.log('Quantity updated:', quantity);

function updateQuantity(change) {
	quantity += change;
	// Ensure the quantity doesn't go below 0
	quantity = Math.max(0, quantity);
	// Update the input value
	document.getElementById('quantityInput').value = quantity;

	// Update the hidden input field for quantity in the form
	document.getElementById('selectedQuantity').value = quantity;

	// Log to the console
	console.log('Quantity updated:', document.getElementById('selectedQuantity').value);
}

$(document).ready(function() {
	var selectedItemID = ""; // Variable to store the selected item ID

	$(".btn-group button").click(function() {
		selectedItemID = $(this).val();
		$("#selectedItemID").val(selectedItemID);

		// Log to the console
		console.log('Selected item ID:', document.getElementById('selectedItemID').value);
	});
});

function addToCart() {
	var selectedItemID = $("#selectedItemID").val();
	var quantity = $("#selectedQuantity").val();
	var errorContainer = $("#errorContainer");

	if (selectedItemID && quantity > 0) {
		var data = {
			itemID: selectedItemID,
			quantity: quantity
		};

		$.ajax({
			type: "POST",
			url: "addToCart",
			data: data,
			success: function(response) {
				errorContainer.text("");

				Swal.fire({
					icon: 'success',
					title: 'Item added to cart successfully',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#ffc107;',
					confirmButtonText: 'OK',
					cancelButtonText: 'Go to Cart',
					allowOutsideClick: false
				}).then((result) => {
					if (!result.isConfirmed) {
						window.location.href = '/AZShopFurni/carts';
					}
				});
			},
			error: function(error) {
				console.error("Please choose the item", error);

				errorContainer.text("Error adding to cart. Please choose the item.");
			}
		});
	} else {
		errorContainer.text("Please select an item before adding to the cart.");
	}
}
