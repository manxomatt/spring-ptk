-- Migration V1: Add principal_id column to brands table
-- This column is required for the Brand entity to function properly
-- Flyway will automatically track this migration

-- Add principal_id column to brands table
-- Using a procedure to check if column exists before adding (MySQL doesn't support IF NOT EXISTS for ADD COLUMN)
SET @dbname = DATABASE();
SET @tablename = 'brands';
SET @columnname = 'principal_id';
SET @preparedStatement = (SELECT IF(
    (
        SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_SCHEMA = @dbname
        AND TABLE_NAME = @tablename
        AND COLUMN_NAME = @columnname
    ) > 0,
    'SELECT 1',
    CONCAT('ALTER TABLE ', @tablename, ' ADD COLUMN ', @columnname, ' VARCHAR(36) NULL')
));
PREPARE alterIfNotExists FROM @preparedStatement;
EXECUTE alterIfNotExists;
DEALLOCATE PREPARE alterIfNotExists;
