function showMoreImages() {
	const hiddenImages = document.querySelectorAll('.hidden');
	hiddenImages.forEach((img) => {
		img.style.display = 'block';
	});
	document.getElementById('seeMoreButton').style.display = 'none';
}

const productContainers = [...document.querySelectorAll('.product-container')];
const nxtBtn = [...document.querySelectorAll('.nxt-btn')];
const preBtn = [...document.querySelectorAll('.pre-btn')];

productContainers.forEach((item, i) => {
	let containerDimensions = item.getBoundingClientRect();
	let containerWidth = containerDimensions.width;

	nxtBtn[i].addEventListener('click', () => {
		item.scrollLeft += containerWidth;
	})

	preBtn[i].addEventListener('click', () => {
		item.scrollLeft -= containerWidth;
	})
})