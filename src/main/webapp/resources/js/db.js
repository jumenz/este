/**
 * User: julia
 * Date: 26.03.13
 */

/**
 * Checks if applicant form is valid
 *
 * @returns {boolean}
 */
function chekAddressForm() {
    var error_message = "Fehler:\n";
    var error = false;
    var prefix = false;
    var name = false;
    var prename = false;
    var mail = false;
    var phone = false;

    if (!document.new.prefix[0].checked && !document.new.prefix[1].checked) {
    error_message += "- Anrede fehlt\n";
    error = true;
    prefix = true;
    }
    if (document.new.name.value == "") {
        error_message += "- Name fehlt\n";
        error = true;
        name = true;
        }
    if (document.new.prename.value == "") {
        error_message += "- Vorname fehlt\n";
        error = true;
        prename = true;
        }
    if (document.new.mail.value == "") {
        error_message += "- E-Mail fehlt\n";
        error = true;
        mail = true;
        }
    if (!validEmail(document.new.mail.value)) {
        error_message += "- E-Mail ung\u00fcltig\n";
        error = true;
        mail = true;
        }
    var chkZ = 1;
    if (document.new.phone.value != "") {
        for (var i = 0; i < document.new.phone.value.length; ++i)
        if ((document.new.phone.value.charAt(i) < "0" || document.new.phone.value.charAt(i) > "9") &&
        document.new.phone.value.charAt(i) != "-")
        chkZ = -1;
        }
    if (chkZ == -1) {
        error_message += "- Telefonnummer ung\u00fcltig\n";
        error = true;
        phone = true;
        }
    if (error == true) {
        if (prefix) { document.new.prefix[0].focus(); }
        else if (name) { document.new.name.focus(); }
        else if (prename) { document.new.prename.focus(); }
        else if (mail) { document.new.mail.focus(); }
        else if (phone) { document.new.phone.focus(); }
        alert(error_message);
        return false;
    }
    return true;
}

/**
* Validate mail-addresses
* @param email
* @return {Boolean}
*/
function validEmail(email) {
    var strReg = "^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+\.+([a-zA-Z0-9]{2,4})+$";
    var regex = new RegExp(strReg);
    return(regex.test(email));
}

/**
 * Checks if reset is deliberate
 * @returns {*}
 */
function resetChk () {
    var chk = window.confirm("Eingaben wirklich löschen?");
    return (chk);
}

/**
 * Checks if deletion is deliberate
 * @returns {*}
 */
function deleteChk () {
    var chk = window.confirm("Auswahl wirklich löschen?");
    return (chk);
}