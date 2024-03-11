table 50101 "Sales Transaction"
{
    DataClassification = ToBeClassified;
    DrillDownPageId = "Sales Transaction";

    fields
    {
        field(1; "Line NO."; Integer)
        {
            DataClassification = ToBeClassified;

        }
        field(2; "Salesperson Code"; Code[20])
        {
            TableRelation = "Salesperson/Purchaser" where("Commission %" = filter('<>0'));
        }
        field(3; "NO."; Code[20])
        {
            TableRelation =
            IF (Type = CONST(Account)) "G/L Account"."No."
            ELSE
            IF (Type = CONST(Item)) Item."No."
            ELSE
            IF (Type = CONST(Resource)) Resource."No.";
        }
        field(4; Amount; Decimal) { }
        field(5; "Type"; Enum "TransactionSales Line Type") { }
    }

    keys
    {
        key(PK; "Line NO.")
        {
            Clustered = true;
        }
    }

}