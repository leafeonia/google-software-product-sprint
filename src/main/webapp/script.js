// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


function loadCommodities() {
  fetch('/data/').then(response => response.json()).then((commodities) => {
    const commodityListElement = document.getElementById('commodity-list');
    commodities.forEach((commodity) => {
      commodityListElement.appendChild(createCommodityElement(commodity));
    })
  });
}

/** Creates an element that represents a commodity */
function createCommodityElement(commodity) {
  const commodityElement = document.createElement('li');
  //taskElement.className = 'task';

  const titleElement = document.createElement('span');
  titleElement.innerText = "name: " + commodity.name + "  number: " + commodity.number + "  price: " + commodity.price + "  last modified on: " + commodity.last_time;

  commodityElement.appendChild(titleElement);
  return commodityElement;
}