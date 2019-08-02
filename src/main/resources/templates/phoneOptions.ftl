<#import "parts/common.ftl" as c>

<@c.page>

    <p class="h4 text-secondary text-center mb-5">Phone's Specifications</p>

    <main class="container">

        <div class="card mb-3 mx-auto" style="max-width: 940px; max-height: 200px;">
            <div class="row no-gutters">
                <div class="col-3 p-2" >
                    <div class="col-8 mx-auto">
                        <img src="/img/${phone.fileName}" class="card-img" alt="Phone">
                    </div>
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <h5 class="card-title">${phone.manufacturer} ${phone.model}</h5>
                        <p class="card-text">${phone.monitor}", CPU: ${phone.cpu},
                            RAM ${phone.ram}Gb, flash memory: ${phone.storageSize}Gb,
                            dual SIM: ${phone.dualSim?then("Yes", "No")},
                            flash card: ${phone.flashCard?then("Yes", "No")}.</p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${phone.price}</h5>
                    </div>
                </div>
            </div>
        </div>

    </main>
</@c.page>