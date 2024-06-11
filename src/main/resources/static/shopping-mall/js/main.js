const BASE_URL = 'http://localhost:8080/api';


// document.addEventListener("DOMContentLoaded", () => {
//     loadProducts();
// });
//
// function loadProducts() {
//     fetch('api/product.js')
//         .then(response => response.json())
//         .then(products => {
//             const productList = document.getElementById('product-list');
//             products.forEach(product => {
//                 const productItem = document.createElement('div');
//                 productItem.innerHTML = `
//                     <h3>${product.name}</h3>
//                     <p>${product.description}</p>
//                     <p>${product.price}</p>
//                     <button onclick="addToCart(${product.id})">Add to Cart</button>
//                 `;
//                 productList.appendChild(productItem);
//             });
//         });
// }
//
// function addToCart(productId) {
//     // Add product to cart (this can be improved with proper cart handling)
//     alert(`Product ${productId} added to cart!`);
// }
