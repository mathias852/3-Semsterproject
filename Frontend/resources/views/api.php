<!DOCTYPE html>
<html>
<head>
<h1>Current batches: </h1>
</head>
<body>
    <?php foreach ($result as $item): ?>
        <li>

        <label>ID: <?php echo $item['id'] ?></label>
        <label>Amount: <?php echo $item['amount'] ?></label>

        </li>
    <?php endforeach;?>


    <h2>New batch:</h2>
    <form action="<?php echo route("api.store")?>" method="post">
        <?php echo csrf_field(); ?>

        <label>Amount: </label>
        <input type="text" id="amount" name="amount">
        <label>Type ID:</label>
        <input type="text" id="type" name="type">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
