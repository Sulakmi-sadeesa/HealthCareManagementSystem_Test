// ============================================
// MEDI HOUSE
// Main JavaScript
// ============================================


// ================================
// MOBILE MENU
// ================================

const mobileMenuBtn =
    document.getElementById("mobileMenuBtn");

const mobileMenu =
    document.getElementById("mobileMenu");


if (mobileMenuBtn && mobileMenu) {

    mobileMenuBtn.addEventListener("click", function () {

        mobileMenu.classList.toggle("show");

        const icon =
            mobileMenuBtn.querySelector("i");

        if (mobileMenu.classList.contains("show")) {

            icon.classList.remove("fa-bars");

            icon.classList.add("fa-xmark");

        } else {

            icon.classList.remove("fa-xmark");

            icon.classList.add("fa-bars");

        }

    });

}


// ================================
// CLOSE MOBILE MENU
// WHEN LINK IS CLICKED
// ================================

const mobileLinks =
    document.querySelectorAll(".mobile-menu a");


mobileLinks.forEach(function (link) {

    link.addEventListener("click", function () {

        if (mobileMenu) {

            mobileMenu.classList.remove("show");

        }

        if (mobileMenuBtn) {

            const icon =
                mobileMenuBtn.querySelector("i");

            icon.classList.remove("fa-xmark");

            icon.classList.add("fa-bars");

        }

    });

});


// ================================
// NAVBAR SCROLL EFFECT
// ================================

const navbar =
    document.querySelector(".navbar");


window.addEventListener("scroll", function () {

    if (!navbar) return;

    if (window.scrollY > 30) {

        navbar.classList.add("scrolled");

    } else {

        navbar.classList.remove("scrolled");

    }

});


// ================================
// AI SUGGESTION BUTTONS
// ================================

const aiSuggestionButtons =
    document.querySelectorAll(".ai-suggestions button");

const aiInput =
    document.querySelector(".ai-input input");


aiSuggestionButtons.forEach(function (button) {

    button.addEventListener("click", function () {

        if (aiInput) {

            aiInput.value =
                button.textContent.trim();

            aiInput.focus();

        }

    });

});


// ================================
// AI DEMO SEND BUTTON
// ================================

const aiSendButton =
    document.querySelector(".ai-input button");


if (aiSendButton) {

    aiSendButton.addEventListener("click", function () {

        if (!aiInput) return;

        const message =
            aiInput.value.trim();

        if (message === "") {

            return;

        }

        alert(
            "Medi AI will answer this question after the AI system is connected."
        );

        aiInput.value = "";

    });

}


// ================================
// SMOOTH SCROLL
// ================================

const anchorLinks =
    document.querySelectorAll('a[href^="#"]');


anchorLinks.forEach(function (link) {

    link.addEventListener("click", function (event) {

        const targetId =
            link.getAttribute("href");

        if (
            targetId === "#" ||
            !targetId
        ) {
            return;
        }

        const target =
            document.querySelector(targetId);

        if (target) {

            event.preventDefault();

            target.scrollIntoView({
                behavior: "smooth"
            });

        }

    });

});


// ================================
// CURRENT YEAR
// ================================

const yearElements =
    document.querySelectorAll(".current-year");


yearElements.forEach(function (element) {

    element.textContent =
        new Date().getFullYear();

});