<#import "parts/common.ftl" as c>

<@c.page>
    <main class="container">

        <p class="h4 text-secondary text-center mb-5">Laptop's Specifications</p>

        <div class="card mb-3 mx-auto" style="max-width: 940px;">
            <div class="row no-gutters">
                <div class="col-3 p-2">
                    <img src="/img/${laptop.fileName}" class="card-img" alt="Laptop">
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <h5 class="card-title">${laptop.manufacturer} ${laptop.model}</h5>
                        <p class="card-text">${laptop.monitor}", ${laptop.cpu}, ${laptop.ram}Gb,
                            ${laptop.storageType}, ${laptop.storageSize}Gb, video card: ${laptop.videoCard}.</p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${laptop.price}</h5>
                    </div>
                </div>
            </div>
        </div>

    </main>
</@c.page>