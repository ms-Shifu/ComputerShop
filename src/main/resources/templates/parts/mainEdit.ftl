<main>
    <div class="container">

        <#--ADD FORM-->

        <div class="mb-4">
            <h4 class="text-primary mb-4">Add new laptop</h4>

            <a class="btn btn-primary" data-toggle="collapse" href="#collapseAddNewLaptop" role="button" aria-expanded="false" aria-controls="collapseExample">
                Press to open
            </a>

            <div class="collapse mt-3" id="collapseAddNewLaptop">
                <form method="post" action="/laptopsEditAdd" enctype="multipart/form-data" autocomplete="on">
                    <div class="form-group">
                    <#--<label for="input1">Manufacturer</label>-->
                        <input type="text" name="manufacturer" class="form-control" id="input1" placeholder="Enter Manufacturer" required maxlength="50">
                    </div>
                    <div class="form-group">
                    <#--<label for="input2">Model</label>-->
                        <input type="text" name="model" class="form-control" id="input2" placeholder="Enter Model" required maxlength="50">
                    </div>
                    <div class="form-group">
                    <#--<label for="input3">Monitor</label>-->
                        <input type="number" name="monitor" class="form-control" id="input3" placeholder="Enter Monitor, inch" required min="7" max="19">
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
                    <#--<label for="input6">Storage Type</label>-->
                        <input type="text" name="storageType" class="form-control" id="input6" placeholder="Enter Storage Type" required maxlength="50">
                    </div>
                    <div class="form-group">
                    <#--<label for="input7">Storage Size</label>-->
                        <input type="number" name="storageSize" class="form-control" id="input7" placeholder="Enter Storage Size, Gb" required min="100" max="99999">
                    </div>
                    <div class="form-group">
                    <#--<label for="input8">Video Card</label>-->
                        <input type="text" name="videoCard" class="form-control" id="input8" placeholder="Enter Video Card" required maxlength="50">
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
            <h4 class="text-primary ">Settings</h4>
            <table class="mt-4 table">
                <thead>
                <tr class="row">
                    <th scope="col" class="col-1">Manufact.</th>
                    <th scope="col" class="col-3">Model</th>
                    <th scope="col" class="col-1">Monitor</th>
                    <th scope="col" class="col-2">CPU</th>
                    <th scope="col" class="col-1">RAM, Gb</th>
                    <th scope="col" class="col-1">Storage type</th>
                    <th scope="col" class="col-1">Storage size, Gb</th>
                    <th scope="col" class="col-2">Video card</th>
                </tr>
                </thead>
            </table>


            <#list laptops as laptop>
            <form action="/laptopsEditDelete" method="post">
                <div class="form-row align-items-center my-3">
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput1">manufacturer</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput1"
                               name="manufacturer" value="${laptop.manufacturer?capitalize}" maxlength="50">
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInput2">model</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput2"
                               name="model" value="${laptop.model}" maxlength="50">
                    </div>
                     <div class="col-1">
                        <label class="sr-only" for="inlineFormInput3">monitor</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput3"
                               name="monitor" value="${laptop.monitor}" min="7" max="19">
                    </div>
                     <div class="col-2">
                        <label class="sr-only" for="inlineFormInput4">cpu</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput4"
                               name="cpu" value="${laptop.cpu}" maxlength="50">
                    </div>
                     <div class="col-1">
                        <label class="sr-only" for="inlineFormInput5">ram</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput5"
                               name="ram" value="${laptop.ram}" min="1" max="999">
                    </div>
                     <div class="col-1">
                        <label class="sr-only" for="inlineFormInput6">storageType</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput6"
                               name="storageType" value="${laptop.storageType}" maxlength="50">
                    </div>
                    <div class="col-1">
                        <label class="sr-only" for="inlineFormInput7">storageSize</label>
                        <input type="number" class="form-control mb-2" id="inlineFormInput7"
                               name="storageSize" value="${laptop.storageSize?c}" min="100" max="99999">
                    </div>
                    <div class="col-2">
                        <label class="sr-only" for="inlineFormInput8">videoCard</label>
                        <input type="text" class="form-control mb-2" id="inlineFormInput8"
                               name="videoCard" value="${laptop.videoCard}" maxlength="50">
                    </div>

                    <div class="form-row ml-auto">
                        <div class="col-auto">
                            <button type="submit" name="buttonEdit" value="edit" class="btn btn-primary mb-2">Edit</button>
                            <button type="submit" name="buttonEdit" value="delete" class="btn btn-primary mb-2">Delete</button>
                        </div>
                    </div>

                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="hidden" name="id" value="${laptop.id}">
                </div>
            </form>
            </#list>
        </div>




    </div>
</main>