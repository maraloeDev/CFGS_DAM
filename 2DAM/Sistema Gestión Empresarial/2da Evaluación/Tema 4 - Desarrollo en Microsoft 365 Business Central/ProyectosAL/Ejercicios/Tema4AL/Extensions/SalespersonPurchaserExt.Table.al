tableextension 50100 "Salesperson/Purchaser" extends "Salesperson/Purchaser"
{

    fields
    {
        // Add changes to table fields here
        field(50100; "Total Sales"; Decimal)
        {
            //Configuramos como campo calculado
            Editable = false;
            FieldClass = FlowField;
            CalcFormula = sum("Sales Transaction".Amount
                        where("Salesperson Code" = field(Code),
                        Type = field("Filter Type")));
        }
        field(50101; "Filter Type"; Enum "TransactionSales Line Type")
        {
            //Configuramos como FlowFilter para que intervenga en el cálculo del total ventas
            FieldClass = FlowFilter;
        }

    }

}