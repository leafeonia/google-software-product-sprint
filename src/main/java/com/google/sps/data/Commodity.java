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

package com.google.sps.data;

import java.util.Date;

/** An item on a todo list. */
public final class Commodity {

  private final String name;
  private final long number;
  private final double price;
  private final long item_id;
  private final String last_time;

  public Commodity(String name, long number, double price, long item_id, String last_time) {
    this.name = name;
    this.number = number;
    this.price = price;
    this.item_id = item_id;
    this.last_time = last_time;
  }
}