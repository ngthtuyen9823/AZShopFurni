function changeMainImage(newImage) {
	document.getElementById('mainImage').src = newImage;
	document.getElementById('mainImageLink').href = newImage;
}

var quantity = 1; // Initial quantity

function updateQuantity(change) {
	quantity += change;
	// Ensure the quantity doesn't go below 0
	quantity = Math.max(0, quantity);
	// Update the input value
	document.getElementById('quantityInput').value = quantity;

	// Update the hidden input field for quantity in the form
	document.getElementById('selectedQuantity').value = quantity;
}

$(document).ready(function() {
	var selectedItemID = ""; // Variable to store the selected item ID

	$(".btn-group button").click(function() {
		selectedItemID = $(this).val();
		$("#selectedItemID").val(selectedItemID);
	});
});