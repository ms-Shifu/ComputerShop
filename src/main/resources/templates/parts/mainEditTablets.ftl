<main class="container">

<#--ADD FORM-->

    <div class="mb-4">
        <h4 class="text-secondary mb-4">Add new tablet</h4>

        <a class="btn btn-primary" data-toggle="collapse" href="#collapseAddNewLaptop" role="button" aria-expanded="false" aria-controls="collapseExample">
            Press to open
        </a>

        <div class="collapse mt-3" id="collapseAddNewLaptop">
            <form method="post" action="/tabletsEditAdd" enctype="multipart/form-data" autocomplete="on">
                <div class="form-group">
                <#--<label for="input1">Manufacturer</label>-->
                    <input type="text" name="manufacturer" class="form-control" id="input1" placeholder="Enter Manufacturer" required maxlength="50">
                </div>
                <div class="form-group">
                <#--<label for="input2">Model</label>-->
                    <input type="text" name="model" class="form-control" id="input2" placeholder="Enter Model" required maxlength="50">
                </div>
                 <div class="form-group">
                <#--<label for="input21">Model</label>-->
                    <input type="text" name="os" class="form-control" id="input21" placeholder="Enter OS" required maxlength="50">
                </div>
                <div class="form-group">
                <#--<label for="input3">Monitor</label>-->
                    <input type="number" name="monitor" class="form-control" id="input3" placeholder="Enter Screen Size, inch" required min="5" max="14">
                </div>
                <div class="form-group">
                <#--<label for="input4">CPU</label>-->
                    <input type="text" name="cpu" class="form-control" id="input4" placeholder="Enter CPU" required maxlength="50">
                </div>
                <div class="form-group">
                <#--<label for="input5">RAM</label>-->
                    <input type="number" name="ram" class="form-control" id="input5" placeholder="Enter RAM, Gb" required min="1" max="999">
                </div>
                <div class="form-group">
                    <h6>Flash Card</h6>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadioInline61" name="flashCard" value="false" class="custom-control-input" checked>
                        <label class="custom-control-label" for="customRadioInline61">No</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadioInline62" name="flashCard" value="true" class="custom-control-input">
                        <label class="custom-control-label" for="customRadioInline62">Yes</label>
                    </div>
                </div>
                <div class="form-group">
                <#--<label for="input7">Storage Capacity</label>-->
                    <input type="number" name="storageSize" class="form-control" id="input7" placeholder="Enter Storage Capacity, Gb" required min="8" max="99999">
                </div>
                <div class="form-group">
                <#--<label for="input8">Video Card</label>-->
                    <input type="text" name="videoCard" class="form-control" id="input8" placeholder="Enter Video Adapter" required maxlength="50">
                </div>
                <div class="form-group">
                <#--<label for="input9">Price</label>-->
                    <input type="number" name="price" class="form-control" id="input9" placeholder="Price" required min="0.01" max="99999.99" step="0.01">
                </div>


                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" class="custom-file-input" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </div>
    </div>


<#--EDIT AND DELITE FORM-->

    <div class="my-5">
        <h4 class="text-secondary ">Settings</h4>
        <table class="mt-4 table">
            <thead>
            <tr class="row">
                <th scope="col" class="col-1">Manufact.</th>
                <th scope="col" class="col-2">Model</th>
                <th scope="col" class="col-1">OS</th>
                <th scope="col" class="col-1">Screen Size</th>
                <th scope="col" class="col-1">CPU</th>
                <th scope="col" class="col-1">RAM, Gb</th>
                <th scope="col" class="col-1">Flash Card</th>
                <th scope="col" class="col-1">Storage Size, Gb</th>
                <th scope="col" style="width: 150px;">Video Adapter</th>
                <th scope="col" style="width: 125px;">Price</th>

            </tr>
            </thead>
        </table>


            <#list tablets as tablet>
            <form action="/tabletsEditDelete" method="post">
                <div class="form-row align-items-center my-3">
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput1">manufacturer</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput1"
                               name="manufacturer" value="${tablet.manufacturer?capitalize}" maxlength="50">
                    </div>
                    <div class="col-2">
                        <label class="sr-only" for="inlineFormInput2">model</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput2"
                               name="model" value="${tablet.model}" maxlength="50">
                    </div>
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput21">os</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput21"
                               name="os" value="${tablet.os}" maxlength="50">
                    </div>
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput3">monitor</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput3"
                               name="monitor" value="${tablet.monitor}" min="5" max="14">
                    </div>
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput4">cpu</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput4"
                               name="cpu" value="${tablet.cpu}" maxlength="50">
                    </div>
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput5">ram</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput5"
                               name="ram" value="${tablet.ram}" min="1" max="999">
                    </div>
                    <div class="col-1">
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="inlineFormInput61" name="flashCard" value="false" class="custom-control-input"
                                ${tablet.flashCard?string("", "checked")}>
                            <label class="custom-control-label" for="inlineFormInput61">No</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="inlineFormInput62" name="flashCard" value="true" class="custom-control-input"
                                ${tablet.flashCard?string("checked", " ")}>
                            <label class="custom-control-label" for="inlineFormInput62">Yes</label>
                        </div>
                    </div>
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput7">storageSize</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput7"
                               name="storageSize" value="${tablet.storageSize?c}" min="8" max="99999">
                    </div>
                    <div style="width: 150px;">
                        <label class="sr-only" for="inlineFormInput8">videoCard</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput8"
                               name="videoCard" value="${tablet.videoCard}" maxlength="50">
                    </div>
                    <div class="ml-1" style="width: 125px;">
                        <label class="sr-only" for="inlineFormInput9">price</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput9"
                               name="price" value="${tablet.getPrice()?c}" min="0.01" max="99999.99" step="0.01">
                    </div>


                    <div class="form-row ml-auto">
                        <div class="col-auto">
                            <button type="submit" name="buttonEdit" value="edit" class="btn btn-primary mb-2">Edit</button>
                            <button type="submit" name="buttonEdit" value="delete" class="btn btn-primary mb-2">Delete</button>
                        </div>
                    </div>

                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="hidden" name="id" value="${tablet.id}">
                </div>
            </form>
            </#list>
    </div>

</main>