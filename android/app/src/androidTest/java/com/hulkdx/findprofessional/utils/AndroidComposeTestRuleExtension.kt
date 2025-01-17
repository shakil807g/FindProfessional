package com.hulkdx.findprofessional.utils

import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText

fun AndroidComposeTestRule<*, *>.onNodeWithTextRes(@StringRes res: Int): SemanticsNodeInteraction {
    return onNodeWithText(activity.getString(res))
}

fun AndroidComposeTestRule<*, *>.onNodeWithTagRes(@StringRes res: Int): SemanticsNodeInteraction {
    return onNodeWithTag(activity.getString(res))
}
