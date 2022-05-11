/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.datacapture

import com.google.android.fhir.datacapture.views.QuestionnaireItemViewItem

/*
 * Only allows pagination when there are no validation errors on the current page.
 */
class DefaultPageChangeStrategy : PageChangeStrategy {

  override fun shouldGoToPreviousPage(list: List<QuestionnaireItemViewItem>): Boolean {
    return isErrorOnCurrentPage(list)
  }

  override fun shouldGoToNextPage(list: List<QuestionnaireItemViewItem>): Boolean {
    return isErrorOnCurrentPage(list)
  }

  /*
   * isErrorTriggered will be true if any required field has not yet been provided with an answer
   * */
  private fun isErrorOnCurrentPage(list: List<QuestionnaireItemViewItem>): Boolean {
    return list.none { it.isErrorTriggered }
  }
}