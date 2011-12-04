/*
 * Copyright (c) 2011 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2011 [name of copyright owner]
 */

/**
 * Author: lazyman
 */

/**
 * This method provides password field refresh in browser without ajax. Refresh updates icon
 * and label which shows password 'quality' to user.
 *
 * @param passwordId password field ID attribute
 * @param iconId icon span ID attribute
 * @param labelId label span ID attribute
 * @param regexpBad regular expression for "bad" quality passwords
 * @param regexpMedium regular expression for "medium" quality passwords
 * @param regexpGood regular expression for "good" quality passwords
 */
function updatePasswordValidator(passwordId, iconId, labelId, regexpBad, regexpMedium, regexpGood) {
    //todo implement this method
    jQuery("#" + iconId).toggleClass("icon-bad");
}