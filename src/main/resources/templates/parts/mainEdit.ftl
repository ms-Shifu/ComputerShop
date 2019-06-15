<main>
    <div class="container">
        <form method="post" action="/laptopsEdit" enctype="multipart/form-data" autocomplete="on">
            <div class="form-group">
                <#--<label for="input1">Manufacturer</label>-->
                <input type="text" name="manufacturer" class="form-control" id="input1" placeholder="Enter Manufacturer">
            </div>
            <div class="form-group">
                <#--<label for="input2">Model</label>-->
                <input type="text" name="model" class="form-control" id="input2" placeholder="Enter Model">
            </div>
           <div class="form-group">
                <#--<label for="input3">Monitor</label>-->
                <input type="number" name="monitor" class="form-control" id="input3" placeholder="Enter Monitor, inch">
            </div>
           <div class="form-group">
                <#--<label for="input4">CPU</label>-->
                <input type="text" name="cpu" class="form-control" id="input4" placeholder="Enter CPU">
            </div>
           <div class="form-group">
                <#--<label for="input5">RAM</label>-->
                <input type="number" name="ram" class="form-control" id="input5" placeholder="Enter RAM, Gb">
            </div>
           <div class="form-group">
                <#--<label for="input6">Storage Type</label>-->
                <input type="text" name="storageType" class="form-control" id="input6" placeholder="Enter Storage Type">
            </div>
           <div class="form-group">
                <#--<label for="input7">Storage Size</label>-->
                <input type="number" name="storageSize" class="form-control" id="input7" placeholder="Enter Storage Size, Gb">
            </div>
           <div class="form-group">
                <#--<label for="input8">Video Card</label>-->
                <input type="text" name="videoCard" class="form-control" id="input8" placeholder="Enter Video Card">
            </div>

            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" class="custom-file-input" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </div>
</main>