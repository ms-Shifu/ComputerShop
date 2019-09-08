<#import "parts/common.ftl" as c>

<@c.page>
    <main class="container">

        <p class="h4 mb-4 text-center text-secondary">Online payment</p>

        <form method="POST" action="https://money.yandex.ru/quickpay/confirm.xml">
            <p class="h5 mb-3">Payment's settings</p>
            <input type="hidden" name="receiver" value="410011905845504">
            <input type="hidden" name="label" value="${orderId}">
            <input type="hidden" name="quickpay-form" value="shop">
            <input type="hidden" name="targets" value="Payment">
            <input type="text" name="sum" class="form-control col-2 d-inline" value="${(totalPrice)?c}" readonly> $
            <input type="hidden" name="comment" value="Payment from ComputherShop">

            <div class="form-group">
                <div class="custom-control custom-radio">
                    <input type="radio" name="paymentType" value="AC" id="customRadio2" class="custom-control-input" checked>
                    <label class="custom-control-label" for="customRadio2">Credit Card</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" name="paymentType" value="PC" id="customRadio1" class="custom-control-input">
                    <label class="custom-control-label" for="customRadio1">Yandex.Money</label>
                </div>
            </div>

            <input type="submit" value="Pay" class="btn btn-primary">
        </form>
    </main>
</@c.page>