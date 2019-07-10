<#macro sectionIndex>
    <section>
        <div class="row">
            <#list laptops as laptop>
            <div class="col-lg-4 col-md-6 mt-2">
                <div class="card" style="height: 22rem;">
                    <img src="/img/${laptop.fileName}" class="card-img-top mt-1" alt="laptop">
                    <div class="card-body  text-center">
                        <h5 class="card-title text-center">${laptop.manufacturer} ${laptop.model}</h5>
                        <p class="card-text text-center">${laptop.monitor}", ${laptop.cpu}, ${laptop.ram}Gb,
                           ${laptop.storageType}, ${laptop.storageSize}Gb, video card: ${laptop.videoCard}.</p>
                        <div>
                            <strong class="text-primary mr-4 align-middle">$${laptop.getPrice()?string["0.00"]}</strong>
                            <a href="#" class="btn btn-primary">Add to cart</a>
                        </div>
                        </div>

                </div>
            </div>
                <#else >
                <div class="container">
                    <p>There is no results</p>
                </div>
            </#list>
        </div>
    </section>
</#macro>
