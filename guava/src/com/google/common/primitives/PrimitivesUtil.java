/*
 * Copyright (C) 2008 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
*/

package com.google.common.primitives;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Common utility methods shared across primitive utility classes.
 * Factorizes logic that cannot be generalized due to Java's lack of
 * generics support for primitive types.
 */
final class PrimitivesUtil {
  private PrimitivesUtil() {}

  /**
   * Checks that the total number of elements fits in an int, and returns it.
   * Used by concat() methods in Ints, Longs, etc.
   */
  static int checkNoOverflow(long result) {
    checkArgument(
        result == (int) result,
        "the total number of elements (%s) in the arrays must fit in an int",
        result);
    return (int) result;
  }
}