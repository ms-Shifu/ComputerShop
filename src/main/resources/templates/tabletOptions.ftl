<#import "parts/common.ftl" as c>

<@c.page>

    <p class="h4 text-secondary text-center mb-5">Tablet's Specifications</p>

    <main class="container">

        <div class="card mb-3 mx-auto" style="max-width: 940px; max-height: 200px;">
            <div class="row no-gutters">
                <div class="col-3 p-2 " >
                    <div class="col-8 mx-auto">
                        <img src="/img/${tablet.fileName}" class="card-img" alt="Tablet">
                    </div>
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <h5 class="card-title">${tablet.manufacturer} ${tablet.model}</h5>
                        <p class="card-text">${tablet.os}, ${tablet.monitor}", CPU: ${tablet.cpu}, RAM ${tablet.ram}Gb,
                            flash memory: ${tablet.storageSize}Gb, flash card: ${tablet.flashCard?then("Yes", "No")}.</p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${tablet.price}</h5>
                    </div>
                </div>
            </div>
        </div>

    </main>
</@c.page>