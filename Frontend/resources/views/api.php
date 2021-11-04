<!DOCTYPE html>
<html>
<head>
<h1>Current batch: </h1>
</head>
<body>
    <?php foreach ($result as $item): ?>
        <li>

        <label>ID: <?php echo $item['id'] ?></label>
        <label>Amount: <?php echo $item['amount'] ?></label>

        </li>
    <?php endforeach;?>
</body>
</html>
